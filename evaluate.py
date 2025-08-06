import torch
import torch.nn as nn
import torch.optim as optim
from torch.utils.data import DataLoader
from torchvision import datasets,transforms,models
from PIL import Image
import sys

filepath = ''
if (len(sys.argv) > 1):
    filepath = sys.argv[1]
else :
    print('no image received')
    sys.exit(1)

trans = transforms.Compose([
    transforms.Resize(size = (256,256)),
    transforms.Grayscale(),
    transforms.ToTensor(),
    transforms.Normalize([0.5],[0.5])
])


image = Image.open(filepath)
image = trans(image)
image = image.unsqueeze(0)


model = models.resnet18()
model.conv1 = nn.Conv2d(1, 64, 7, stride=2, padding=3, bias=False)
num_ftrs = model.fc.in_features
model.fc = nn.Linear(num_ftrs,2)

device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
model.load_state_dict(torch.load('resnet weights.pth',map_location=device))
model = model.to(device)
model.eval()

image = image.to(device)
output = model(image)
predicted = torch.max(output,dim=1)[1]
if (predicted.item() ==1) :

    print('Result : "PNEUMONIA "',"\n")
    print("please visit this website for more information on pneumonia :")
    print("https://my.clevelandclinic.org/health/diseases/4471-pneumonia","\n")
    print("please consider visiting a pulmonologist because the chance of a false positve is only 2%")
else :
    print('Result :" NORMAL "',"\n")
    print("please visit this website for more information on pneumonia :")
    print("https://my.clevelandclinic.org/health/diseases/4471-pneumonia","\n")
    print("please consider visiting a pulmonologist if you are experiencing any of the symptoms mentioned in the website because","\n")
    print("Note : there is 1% chance of a false negative result")
