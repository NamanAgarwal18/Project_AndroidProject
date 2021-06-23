# ![final_logo - Copy](https://user-images.githubusercontent.com/53811147/122639587-4f9c5d80-d118-11eb-9916-5deacaa6b877.png) Student Connect - Android Project 

### [Click Here To See The Wireframe](https://whimsical.com/student-connect-2UYaPyhHSAyGvqvHFRGcRN)
## Description
Student Connect is a Social Media app created for android. It has all the basic features like chatting, adding people as friends, posting pictures and interacting with them, searching people and getting in app reccomendations for people that you might know or have a lot in common with. It is created with **Google's Firebase** Firestore backend to store the user data and we have also incorporated many features offered by the Firebase. This project also includes **Machine Learning** to suggest potential friends. 

## Languages Used
1. Kotlin
2. XML
3. JavaScript

## Tools Used
1. Android Studio
2. Android Virtual Device
3. Google Map
4. Firebase Authentication
5. Firebase Firestore (database)
6. Firebase Storage
7. Firebase Cloud Fuctions
8. Firebase Machine Learning kit
   * Face Detection (On Device)
   * Image Labeling (On Cloud)

## Machine Learning
Our App uses 3 different machine learning models in total. Two of them are inbuild models provided by the Google's Firebase based on the Tenserflow Libraries and the third one is build by us using Weighted KNN Classifier algorithm.
#### 1. Image labeling (Inbuilt)
With Cloud Vision's image labeling API, you can recognize entities in an image without having to provide any additional contextual metadata. <br>
Image labeling gives you insight into the content of images. When you use the API, you get a list of the entities that were recognized: people, things, places, activities, and so on. Each label found comes with a score that indicates the confidence the ML model has in its relevance. With this information, you can perform tasks such as automatic metadata generation and content moderation. <br>
For more information about the Api - [Click Here](https://firebase.google.com/docs/ml/label-images?authuser=1) <br>
To understand about the implementation of the Api by us - [Click Here](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/UPLOAD.md#image-labeling-inbuilt)
#### 2. Face Detection (Inbuilt)
With ML Kit's face detection API, you can detect faces in an image, identify key facial features, and get the contours of detected faces. Note that the API detects faces, it does not recognize people. <br>
With face detection, you can get the information you need to perform tasks like embellishing selfies and portraits, or generating avatars from a user's photo. Because ML Kit can perform face detection in real time, you can use it in applications like video chat or games that respond to the player's expressions. <br>
For more information about the Api - [Click Here](https://developers.google.com/ml-kit/vision/face-detection) <br>
To understand about the implementation of the Api by us - [Click Here](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/UPLOAD.md#face-detection-inbuilt)
#### 3. Friends Recommendation Engine 
We use user details to make friend suggestions. Friend suggestions depend on the professional course of the user, the level of completion of their course, posts they have made (Their Personal Interests) and interacted with and the people who they are friends with. We have used **Weighted KNN Classifier** for friend recommendations. Each tag is assigned particular value. The friend list is assigned the most value, followed by the course and level of course. Then comes the value of tag of each post, uploaded by the user and finally the least priority is given to the posts with which the user has interacted. <br>
To understand more about the algorithm used and how we used it - [Click Here](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/SUGGESTION.md#machine-learning-concept-used)

## Functionalities
1. Students can Signin or SignUp in the app using appropreate credentials.
2. Users can add other people as their friends.
3. Users can upload posts in the form of photos and tag people in it.
4. Users can view and interact eith the posts uploaded by their friends by liking and comenting them.
5. Usrers also have the option to remove their tag from photos.
6. Users can search for other people by their:
   * Name
   * Username
   * College
   * Branch
7. Users can search for a particular college to get their address and details.
8. Users can get reccomendations of people they can add as a friend based on their college, vacinity and on their interests.
9. Users can chat with other users in our chat feature.
10. In the chat, users can: 
    * Like/dislike a message
    * Delete their own message
    * Reply to a message
    * Forward a message
    * Copy a message

## Cloud Fucntions
Cloud Functions for Firebase is a serverless framework that lets you automatically run backend code in response to events triggered by Firebase features and HTTPS requests. Your **JavaScript** or **TypeScript** code is stored in Google's cloud and runs in a managed environment. There's no need to manage and scale your own servers.
For more information about the **Firebase Cloud Funtions** [Click Here](https://firebase.google.com/docs/functions)
### Cloud Functions Created
We have created in total 7 cloud fucntions out of which 5 cloud functions are used in our application. All these Cloud functions are written in **JavaScript** by us and executed on Google's Cloud. These fucntions are deployed on the ```asia-south1``` server as it is the nearest to India and provides low latency. The cloud fucntions currently in use by our app are:
1. [createUser](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/SIGNUP.md#cloud-function---createuser)
2. [uploadPost](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/UPLOAD.md#cloud-function---uploadpost)
3. [deletePost](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/PROFILE.md#cloud-function---deletepost)
4. [likePost](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/MAINFEED.md#cloud-function---likepost)
5. [dislikePost](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/MAINFEED.md#cloud-function---dislikepost)
#### Click on the fucntion to know more about it.


## Gestures Incorporated
* Single Tap
* Double Tap
* Long Press
* Overridden Back buton 
* Swipe Up
* Swipe Down
* Swipe Left
* Swipe Right

## Navigation through the App
You can navigate to different activities by intuitively swiping left and right to switch between them. Along with that wherever there is a search bar available you can activate it by swiping down and eactivate it by swiping it up. 

## APIs and External Libraries Used
* Circular Image View – loads image in a circular fashion 
  * ```de.hdodenhof:circleimageview:3.1.0```
* Picasso – image processing tool.
  * ```com.squareup.picasso:picasso:2.71828```
* Glide – image rendering tool.
  * ```com.github.bumptech.glide:glide:4.11.0```
<details><summary>Click Here To See All</summary>
 
* Shape Image View Library – to set image shape.
  * ```com.github.siyamed:android-shape-imageview:0.9.3@aar```
* Justify text library – aligns the text in justified view.
  * ```me.biubiubiu.justifytext:library:1.1```
* Styleable toast – builds custom toast view.
  * ```com.muddzdev:styleabletoast:2.2.4```
* Card View – creates depth effect in the layout.
  * ```androidx.cardview:cardview:1.0.0```
* Palette – extracts prominent colours from the image.
  * ```androidx.palette:palette:1.0.0```
* Groupie View Holder – provides a ready-made adapter for recycler view.
  * ```com.xwray:groupie:2.8.1```
* Android Play Services and Map Utils – provides map view and map functions.
  * ```com.google.android.gms:play-services-maps:17.0.0```
  * ```com.google.maps.android:android-maps-utils-v3:1.3.1```
  * ```com.google.auto.value:auto-value-annotations:1.6.5```
  * ```com.google.android.libraries.maps:maps:3.1.0-beta```
* Firebase Cloud Functions - provides the fucntionality of defining javascript fucntions on the cloud.
  * ```com.google.firebase:firebase-functions:19.2.0```
* Image Labeling - used to call the cloud image labling model by firebase.
  * ```com.google.mlkit:image-labeling:17.0.3```
  * ```com.google.android.gms:play-services-mlkit-image-labeling:16.0.3```
* Face Detection - used to call on device face detection model by firebase.
  * ```com.google.mlkit:face-detection:16.0.6```
  * ```com.google.android.gms:play-services-mlkit-face-detection:16.1.5```
 
</details>
 
