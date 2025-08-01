# X-ray Image Classification   
- A deep learning model which classifies an xray image to be pneumonic or normal.
- Constraint : The model is specific for the pediatric patients (ages 1 to 5 years).
## Table of Contents
- [About](#about)
- [Dataset](#dataset)
- [Installation](#installation)
- [Usage](#usage)
- [Metrics](#results)

# About 
- The project intends to diagnose the pneumonia from the xray image of the patients of ages 1 to 5 years.
- The model the trained on the xray images of the peditatric patients(aged 1 to 5 years).
### why this ai model is useful 
 - Using X-rays, pneumonia can be detected even before symptoms become visible. This is often the case  in children between the ages of 1 and 4  is this wrong [source](https://www.ncbi.nlm.nih.gov/books/NBK525772/).
 - Diagnosing pneumonia in young children is fairly difficult, even for experienced doctors. Their symptoms can be misleading. this model can provide a fast, objective, and reliable piece of evidence to support a doctor's judgment, helping them see through the ambiguity.
 - By focusing on the under-5 age group, This model targets the population where pneumonia is most deadly and where rapid diagnosis can have the most impact. Tool can serve as an assistant, helping doctors confirm their suspicions quickly and confidently.
 - One Fact : **Pneumonia accounts for 14% of all deaths of children under 5 years old, killing 740 180 children in 2019** [source](https://www.who.int/news-room/fact-sheets/detail/pneumonia).
### libraries 
- torchvision,torch,PIL,scipy,numpy
    #### model used :
    - torchvision.models.resnet18


# Dataset 
### dataset used for training 
  - The dataset used : [DATASET](https://www.kaggle.com/datasets/paultimothymooney/chest-xray-pneumonia)
  - It contains 5,863 X-Ray images (JPEG) and 2 categories (Pneumonia/Normal).
  - The dataset only contains of the xray images of the pediatric patients.
### structure of the dataset 
  - the dataset contains three folders : train , test , val.
  - each folder has two sub folders `Noraml` `Pneumonic`.
  - the torch considers each of the subfolder as a class by default.


# Installation
- No formal installation is required. You simply need to download the project files and run the application from your terminal.
## steps to setup 
  - Clone the Repository :
    - Open your terminal, navigate to where you want to store the project, and run this command: `git clone https://github.com/your-username/your-repository-name.git`
  - Running the Application :
    - `javac pneumonia.java`
    - after this command is executed
    - `java pneumonia`
  - The application's Graphical User Interface should now appear now

 # Usage
<img width="751" height="593" alt="image" src="https://github.com/user-attachments/assets/0a79be38-4ea4-4db6-abae-b37a3e2cab9d" /> 

- You are going to see an interface like this  
   ### for the first time 
     - For the time of usage, you have to click on the `install environment` botton on the bottom right of the interface
     - To check if your environment click the `activate the env` button it should output the python and the torch versions 
   ### to diagnose
     - Click on the browse to select the xray
     - It will open a filechooser like this
       
       <img width="502" height="358" alt="image" src="https://github.com/user-attachments/assets/6b26fa03-3efb-4580-ba91-e59e3d1ed15a" />
     - now choose your image by browsing
     - After choosing the image please click on the `click here to get report` button
     - you are going to see a window getting popped up with your report as this
     - <img width="519" height="339" alt="image" src="https://github.com/user-attachments/assets/cbcf2b0d-8bad-4804-b45c-3025275a917b" />
- this is how we are supposed to use this interface pretty straight forward

# Metrics
 
