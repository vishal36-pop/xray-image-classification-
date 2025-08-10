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
- ## requirements :
  - python
  - java  
    (should be installed in the machine in order to run this graphical interface)
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
 Confusion Matrix
- A confusion matrix is a table showing the performance of the classification model. It displays how many samples from each class were correctly or incorrectly predicted. Here’s what each number means in  the matrix:
[[1314   27]
 [  38 3837]]
- 1314: The model correctly predicted class 0 (True Negatives).

- 27: The model incorrectly predicted class 1 when it was actually class 0 (False Positives).

- 38: The model incorrectly predicted class 0 when it was actually class 1 (False Negatives).

- 3837: The model correctly predicted class 1 (True Positives).

- Classification Report
- This report summarizes different metrics for each class:

Class	Precision	Recall	F1-score	Support
0	0.97	0.98	0.98	1341
1	0.99	0.99	0.99	3875
Precision: Out of all the samples predicted as a certain class, how many were actually correct? (Higher is better.)

- Recall: Out of all actual samples of a class, how many did the model identify correctly? (Higher is better.)

- F1-score: The average of precision and recall, giving a balanced score.

- Support: The number of actual samples for each class.

- Overall Metrics
    Metric	Score
    Accuracy	0.99
    Macro Avg	0.98 (precision), 0.99 (recall), 0.98 (f1-score)
    Weighted Avg	0.99 (precision), 0.99 (recall), 0.99 (f1-score)
    Total Support	5216
    Accuracy: Overall, the model predicts correctly 99% of the time.

<img width="443" height="222" alt="image" src="https://github.com/user-attachments/assets/0c516bc8-2391-48d6-b3cb-cb8ff68bebf9" />


