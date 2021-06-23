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
Calculate Similarity based on distance function. 

Here we have used Cosine Similarity.

<p align="center">
  <img align="left" src="https://user-images.githubusercontent.com/53811147/123080073-2d694f00-d43a-11eb-8035-8fb30cfcc3d3.png"> 
  <p align = "left"> The idea is to use distance measure, to find the distance (similarity) between the user and the k-closest users in terms of the professional course of the user, the level of completion of their course, posts they have made and interacted with and the people who they are friends with.
</p></p>

## Our Implementation 

Our algorithm finds **8** users who are compatible to you. We do that by getting the cosine distance of 3 different categories. Those Categories are:
1. How similar they are to you (aka ```tagSinDistance```)
2. How similar you are to them (aka ```tagOtherSinDistance```)
3. How likely is it that you know each other (aka ```userSinDistance```)


### tagSinDistance
Here we collect all the tags for our user with its frequency of occurrence (```v_frequency```) and then we check how many of those tags are present in the other user and with what frequency (```u_frequency```) and based on that we calculate the cosine distance using the formula mentioned above. 
We find out the weight of any tag by the formula 
 

### tagOtherSinDistance
Here we collect all the tags for the other user with its frequency of occurrence (```v_frequency```) and then we check how many of those tags are present in our user and with what frequency (```u_frequency```) and based on that we calculate the cosine distance using the formula mentioned above. 

### userSinDistance
Here we check a hug variety of things that predicts the likelyhood of them knowing eachother. Those things are
1. How many mutual friends they have ?
2. Have they been tagged by same people in posts ?
3. Do they have any previous chats between them ?
4. Do they study in the same college ?
5. Do they study in the same branch and if they do then are they in the same year ?

Based on all the data we try to figureout the answers to these questions and then we calculate the Cosine Distance. 

### Weight for any Tag
While calculating the weiighted cosine distance we need to have a weight assigned to all the tags. We calculate the weight based on the frequency
```kotlin
w = ( v_frequency + 1 ) * ( u_frequency + 1 )
```

### Total Aggregate 
We calculate the total aggregate in the ratio of 16:3:9, giving 57% weightage to the tagSinDistance, 11% weightage to tagOtherSinDistance and around 32% weightage to the userSinDistance. 
```kotlin
var aggregate = ( 16 * tagSinDistance + 3 * tagOtherSinDistance + 9 * userSinDistance) / 28
```

### Percentile
Based on all the aggregates we select 8 users with highest values and assign the best match as high 90s percentile and based on that we calculate the percentile of all the other users. This does not represent the actual percentile but is just a representative of how similar you might be when compared to the other recommended people. This also makes our app feel a little more dynamic.



