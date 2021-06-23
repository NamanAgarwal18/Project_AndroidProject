# Suggestion Activity

## Description 
The activity focuses on creating and using an algorithm that would allow robust friend recommendation, which would help people with similar interests, professional course and similar background to come together. User information such as their professional course, their degree (bachelor, master’s etc), the level of completion of their course, their friends and the type of posts they have posted or interacted with are stored in the backend. This information servers as an input in the backend and after the usage of machine learning algorithm an aggregate value of similarity is found between two users and a percentage of similarity of the two users is found and displayed in the friend recommendation section of the app.

<p align="center">
<img width="700" height="215" src="https://user-images.githubusercontent.com/53811147/123079202-550be780-d439-11eb-8b8b-b7854d50d0b7.png"> 
  <img width="700" height="280" src="https://user-images.githubusercontent.com/53811147/123079214-56d5ab00-d439-11eb-9580-2a72055fea24.png"> 
</p>

## Machine Learning Concept Used
We use user details to make friend suggestions. Friend suggestions depend on the professional course of the user, the level of completion of their course, posts they have made and interacted with and the people who they are friends with.
We have used Weighted KNN Classifier for friend recommendations. Each tag is assigned particular value. The friend list is assigned the most value, followed by the course and level of course. Then comes the value of tag of each post, uploaded by the user and finally the least priority is given to the posts with which the user has interacted. Tags of each post uploaded or interacted with is stored in the background and a value is given to it. If a similar type of post is uploaded by the user or they have interacted with one, the aggregated value is recalculated and the tag value is increased. This new aggregate value is used to people with similar interests and a percentage of compatibility is shown to the user so that they can take a decision whether to befriend another user or not.

## Machine Learning Algorithm - Weighted KNN Algorithm
1. Calculate Similarity based on distance function.
Here we have used Cosine Similarity.
![image](https://user-images.githubusercontent.com/53811147/123080073-2d694f00-d43a-11eb-8035-8fb30cfcc3d3.png)
The idea is to use distance measure, to find the distance (similarity) between the user and the k-closest users in terms of the professional course of the user, the level of completion of their course, posts they have made and interacted with and the people who they are friends with.
