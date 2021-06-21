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
Our app also allows people to dislike any post in their feed that they previously liked. A dislike button appears in the bottom-left corner if the post is already liked. When the dislike button is pressed, then a **Cloud Fucntion** named [dislikePost](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/MAINFEED.md#cloud-function---likepost) is called which does all the heavy lifting.
