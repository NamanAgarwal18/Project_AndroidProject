# Main Feed Activity and Search Fucntonality

## Description
The User Feed is a personalized feed based upon the user’s friend list and interests. It keeps them updated about all the activities of their friends. Like a genuine social media, they can give their opinions in the comment section and like the photo and can also use the search option. 
The Feed is empty if you have no friends but if you have friends then the feed shows the lates 20 posts by your friends. 

<p align="center">
<img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122676535-27862a80-d1fc-11eb-867b-e88b880ad73b.png"> 
<img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122676414-a0d14d80-d1fb-11eb-994b-32ec8f25d1c0.png"> 
</p>

## Cloud Function - likePost
We have also created a cloud fucntion to like a post by a user. Liking a post is not a simple execution in out application. When you like a post, then all the tags associated with post with their confidence above 60% are added to the user as well. We assumed that a user will like a post if he/she likes the things present in the picture in the post. And therefore we can add the tags of the post in the user as well, thus building a robust interest list in each user based on the posts they interact with. 


## Cloud Function - dislikePost
We have also created a cloud fucntion to dislike a previously liked post by a user. Liking a post is not a simple execution in out application similarly disliking the post also reqires a fair bit of work on our end. When you like a post, then all the tags associated with post with their confidence above 60% are added to the user as well. So while disliking the post we remove all those tags from the user that were added at the time of liking it. 

<p align="center">
  <img width="600" height="300" src="https://user-images.githubusercontent.com/53811147/122671989-e6375000-d1e6-11eb-8a79-3001234c0f32.PNG" >
</p>

## User Feed Functionalities
### 1. Background Detection
Our aim was to have a consistent look and feel to all the posts, thats why we decided that all the posts must be shown in a 1:1 ration. But with this we encountered a problem where either we had to force the user to post all the pictures in a 1:1 format or add on an additional background to each picture to show it in 1:1 ratio. We chose to show an additional background with the image and to make it more dynamic and personalised we used a **Palette API** which analyses the post and finds out the second most dominant shade in the entire picture and then we assign that shade to the background. This enables us to get a different coloured background based on the picture being shown to the user thus making it less monotnous and a happy surprise with ech picture. This also helps our app add some level of our creaticity with the post posted by the user. <br>
For more information on **Palette API** [Click Here](https://developer.android.com/jetpack/androidx/releases/palette)

<p align="center">
<img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122726148-5c918c00-d293-11eb-8fef-c2acc62f16cf.gif"> 
</p>

### 2. Liking/Disliking a Post
Our app allows people to like any post in their feed. There is a like button on the bottom-left corner of every post. When the like button is pressed, then a **Cloud Fucntion** named [likePost](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/MAINFEED.md#cloud-function---likepost) is called which does all the heavy lifting. <br>
Our app also allows people to dislike any post in their feed that they previously liked. A dislike button appears in the bottom-left corner if the post is already liked. When the dislike button is pressed, then a **Cloud Fucntion** named [dislikePost](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/MAINFEED.md#cloud-function---dislikepost) is called which does all the heavy lifting.
We also have a feature to smartly detect when the likes have crossed thousands or even millions and we have an elegant way to represent that in our UI by using terms like **"2.13K Likes"** or **"2.34M Likes"** instead of showing the complete number.

<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122728022-53a1ba00-d295-11eb-960c-fd7d8209fcb8.jpg"> 
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122728093-63210300-d295-11eb-8752-0b1176da475c.jpg"> 
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122728174-78962d00-d295-11eb-9b23-7cdd4d7dc72a.png"> 
</p>


### 3. Commenting on a Post
Our app allows people to add comments on any post in their feed. All the comments are saved with the userid of the person who commented and if you click the username then you can visit their profile as well ([Click Here](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/MAINFEED.md#other-users-profile-page) to learn more abouth that). The comments are saved in the backend in the post under the comment section. 


<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122736188-5f917a00-d29d-11eb-84c3-b47b2c5451bd.gif"> 
  <img width="600" height="300" src="https://user-images.githubusercontent.com/53811147/122736389-99628080-d29d-11eb-9c59-c24592959007.png"> 
</p>

### 4. See the Tagged People
While uploading a picture you can tag all the people in the picture. By clicking over the tag count you can see who all were taggged and where were there faces. This feature makes your picture more dynamic and your tags more transparent. 


<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122740277-70dc8580-d2a1-11eb-8a7b-7ec09b6941b9.gif"> 
  </p>

  
## Search Functionalities
### Search Description
The user is granted the ability to search other users or search any college for information. Real time multi-word search is used to get the desired outcome, the search bar not case sensitive. The search uses highly advanced search algorithm, that enables the user to dynamically search the word even with a morpheme/ phrase (part of word) and display results appropriately. For increasing usability, the user can directly get the search option by using **Swipe Down** gesture. The feed is reloaded as soon as the user clears the search bar or as soon as the user **Swipes Up**.

### 1. Search a User
Users have the option to search for another user in the search bar. The user can take the benefit of a highly advanced search algorithm, which allows the user to compares the given morpheme/phrase form all the domains provided and gets the desired outcome. These domains include college, branch, year, username, full name etc. <br>
In the example below **Naman Agarwal** is searched by the college first, then the branch, then the year and then the surname. The final search string being: <br>

<p align="center">
  <b> "bms comp 3 agar" </b> <br>
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122741670-cebd9d00-d2a2-11eb-8f6c-ef6a0b8f003c.gif"> 
</p>

### Other User's Profile Page
After searchinng for a particular user you can see their profile page. After going on somebodies profile page you can do a couple of different fucntions: 
#### 1. Look at their college details 
#### 2. See their DP and their name as well as their discreption
#### 3. Look at the number of friends thay already have. 
#### 4. Can create a chat with them. ([Click Here]() for more information about that)
#### 5. View their posts (only if they are your friend)
#### 6. You can add them as a friend as well. 
Adding somebody as a friend add their prominent tags into your tags. As you might be interested in the same kinds of things as they are. Adding their tags can also help recommend more people like the other user to be your friends. This is one of the ways by which we get to know more and more about you. Adding somebody as friend also enables you to see all they pictures that they have posted in the past on their profile page and all the posts that they will post in future in your feed. <br>
You also have the the option to remove somebody as your friend later on by clicking that button. 
<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122744733-e9454580-d2a5-11eb-871b-435798d0e7a4.gif"> 
</p>
