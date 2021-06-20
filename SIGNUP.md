# Sign-Up Page

## Description 
The signup Page consists of 2 different pages - 
1. Sign - Up page : The Sign-Up page creates new users. All the user information is validated and stored at the backend and the password is hashed before storing into the database.
2. College Details Page : The college details page allows users to select university, college, branch and semester using a drop-down menu and creates all the appropriate documents asynchronously and saves it in the backend.
<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122669973-40cbae80-d1dd-11eb-894d-8ea2d5c1cfcd.jpg" > 
    
 <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122669869-d6b30980-d1dc-11eb-9c13-e9c778e55d7a.gif" > 
</p>


## Backend
For signup we check weather the emailid or the username or the phone number is already taken or not. If everything is unique and all the details are properly filled then we save the user in authentication and create appropreate directories in the backend for the user. 
In the backend we save the Dp in the storage and retrieve the link of the image. Then we create the user in the **"User"** Collection. We also save the user in the **"University"** Collection into their respective directories. We also connect the ```UID``` provided by the **Firebase Authentication** with the username in the **"User Table"**.

<p align="center">
  <img width="400" height="200" src="https://user-images.githubusercontent.com/53811147/122670341-3ad6cd00-d1df-11eb-9106-b772f44292bf.PNG" >
  <img width="400" height="200" src="https://user-images.githubusercontent.com/53811147/122670343-3ca09080-d1df-11eb-8cee-87d63d13ee71.PNG" >
  <img width="400" height="200" src="https://user-images.githubusercontent.com/53811147/122670344-3e6a5400-d1df-11eb-955d-f4190da54b57.PNG" >

</p>

