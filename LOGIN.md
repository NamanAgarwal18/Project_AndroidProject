# Login Page

## Description 
The Login page authenticates the existing users and logs them in to their own feed. All the user information is validated and stored at the backend and all the passwords are hashed before storing into the database. The user logs in using their email id and password. <br>
The login page also remembers whether a user is already logged in and takes them directly to their homepage.

<p align="center">
<img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122665029-80d16800-d1c2-11eb-88c3-d4251e4ebe44.jpg"> 
</p>

---
## Backend 
Most apps need to know the identity of a user. Knowing a user's identity allows an app to securely save user data in the cloud and provide the same personalized experience across all of the user's devices.
Firebase Authentication provides backend services, easy-to-use SDKs, and ready-made UI libraries to authenticate users to your app. It supports authentication using passwords, phone numbers, popular federated identity providers like Google, Facebook and Twitter, and more.
Firebase Authentication integrates tightly with other Firebase services, and it leverages industry standards like OAuth 2.0 and OpenID Connect, so it can be easily integrated with your custom backend. <br>

For logging in we currently only use **"Email/Password"** login methord although we store the phone number as well. <br>

For more information about Firebase Authentication [Click Here](https://firebase.google.com/docs/auth?authuser=1)
 
<p align="center">
 <img   width="600" height="300" src="https://user-images.githubusercontent.com/53811147/122667056-7a48ed80-d1ce-11eb-8f11-782fb2900e53.PNG"> 
</p>


 
<img  align="right" width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122665690-4ec20500-d1c6-11eb-8071-6c0c7eb16ed8.jpg"> 



