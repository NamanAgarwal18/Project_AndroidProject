# Profile Activity

## Description 
The user profile is a complete description of the user that displays the profile photo, the name, user name, and a slider displaying their branch, year and college. It also displays the description provided by the user and posts uploaded by them. The user can also edit these details according on their convince.

## Cloud Function - deletePost


## Features
### 1. See Details
The user can access details such as college name, course enrolled in and year by using the slider, which allows them to slide to see the next information. It is an innovative way to present more information using less space and make the profile even more dynamic. 

<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122763753-549a1200-d2bc-11eb-8930-5c49ffe143de.gif" > 
</p>

### 2. Can see friends
The user can see the number of friends and user name of each friend by selecting the friends’ button. They can directly go to the friends account by selecting the friend to whose account they wish to go. This opens up the others’ profile page. The **Others Profile Page** is a copy of **Profile Page** just filled with all the information relavent to that user <br>
To get more information about **Others Profile Page** [Click Here](https://github.com/NamanAgarwal18/Project_AndroidProject/blob/main/MAINFEED.md#other-users-profile-page)

<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122764362-076a7000-d2bd-11eb-8b36-843254262334.gif" > 
</p>

### 3. Edit Details
The user can access this page by selecting the **Edit Button** or can ```Double Tap``` the information to be changed. The user can change phone number or the Description. After changing the phone number, a set of code is implemented which verifies the phone number and notifies the user if the number is invalid. The user can either change the profile picture or can completely remove it as well. The user can save the changes by changes by selecting the save button or discard all the changes by selecting the exit button.
<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122778700-d729ce00-d2ca-11eb-8dc0-27a0a8d417f9.jpg" > 
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122778715-d98c2800-d2ca-11eb-908d-2b0355d0eba5.jpg" > 
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122778733-dc871880-d2ca-11eb-9a2f-1f50bd4345b3.jpg" > 
</p>

### 4. Interact with your posts 
For enhancing user experience, a grid view is present the bottom of the user profile which presents a tiny sneak peak of the post. The miniature canvas displays the rounded of number of likes and comments (1K, 1M) and also presents a description preview of the post. The user can like or dislike this post from here and a ```Long Press``` of the image opens up the post which displays the actual number of likes and all the comments on the post.
The user can also delete the post from here using deletePost cloud fucntion.

<p align="center">
  <img width="243" height="500" src="https://user-images.githubusercontent.com/53811147/122780383-6d122880-d2cc-11eb-9962-29bd57f2f5f1.gif" > 
</p>
