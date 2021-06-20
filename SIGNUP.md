# Sign-Up Activity and College Details Activity


<a href="https://www.youtube.com/watch?v=XiAdqzualYw" target="_blank"><img src="http://img.youtube.com/vi/XiAdqzualYw/hqdefault.jpg" alt="IMAGE ALT TEXT HERE" width="500" height="375" border="20" />

 
[<h3>Click Here To Watch The Video Demonstration</h3>](https://www.youtube.com/watch?v=XiAdqzualYw)

## Description 
The signup Page consists of 2 different pages - 
1. Sign - Up page : The Sign-Up page creates new users. All the user information is validated and stored at the backend and the password is hashed before storing into the database.
2. College Details Page : The college details page allows users to select university, college, branch and semester using a drop-down menu and creates all the appropriate documents asynchronously and saves it in the backend.
<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122669973-40cbae80-d1dd-11eb-894d-8ea2d5c1cfcd.jpg" > 
    
 <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122669869-d6b30980-d1dc-11eb-9c13-e9c778e55d7a.gif" > 
</p>

## Cloud Function - createUser
We have also created a cloud fucntion to create all the appropriate directories in the backend parallely. This will ensure that all the directories are created even if the app crashes in the middle of the execution. This latency is higher when you compare it with creating all the directories from the device but it it ensures atomicity in the querty and thus always successfully either creates all the directories or creates none of them.

<p align="center">
  <img width="600" height="300" src="https://user-images.githubusercontent.com/53811147/122671989-e6375000-d1e6-11eb-8a79-3001234c0f32.PNG" >
</p>

## Backend
For signup we check weather the emailid or the username or the phone number is already taken or not. If everything is unique and all the details are properly filled then we save the user in authentication and create appropreate directories in the backend for the user. 
In the backend we save the Dp in the storage and retrieve the link of the image. Then we create the user in the **"User"** Collection. We also save the user in the **"University"** Collection into their respective directories. We also connect the ```UID``` provided by the **Firebase Authentication** with the username in the **"User Table"**.

<p align="center">
  <img width="400" height="200" src="https://user-images.githubusercontent.com/53811147/122670341-3ad6cd00-d1df-11eb-9106-b772f44292bf.PNG" >
  <img width="400" height="200" src="https://user-images.githubusercontent.com/53811147/122670343-3ca09080-d1df-11eb-8cee-87d63d13ee71.PNG" >
  <img width="400" height="200" src="https://user-images.githubusercontent.com/53811147/122670344-3e6a5400-d1df-11eb-955d-f4190da54b57.PNG" >

</p>

## Checks Installed
#### We check a few things even before we send the credentials in the backend to create the user. This reduces some of our false backend calls and makes the app feel faster.
1. We Check if the user has left any field empty or not.
<p align="center">
 <img  width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122671015-5394b200-d1e2-11eb-8b14-2be1ce054303.jpg"> 
</p>

2. We also check that if the username is already taken by other user.
<p align="center">
 <img  width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122671046-7a52e880-d1e2-11eb-88bf-7943a09cdb82.jpg"> 
</p>

3. We check if the password is not following the minimum criteria. Our minimum criteria inlcudes:
    * Atleast 6 characters
    * Atleast 1 alphabet
    * Atleast 1 special character
    * Atleast 1 number 
<p align="center">
 <img  width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122671124-d0c02700-d1e2-11eb-855c-94003440e871.jpg"> 
</p>

4. We also check if the phone number is valid or not. In India all the phone number are of 10 digits and start from either 6 or 7 or 8 or 9.
<p align="center">
 <img  width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122671158-f5b49a00-d1e2-11eb-8360-0b26bb459f40.png"> 
</p>

5. We check if the email is in a proper format or not.
6. We also check if the user has selected appropreate college or not.



