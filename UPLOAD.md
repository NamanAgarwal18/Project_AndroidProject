# Upload Post Activity

## Description 
The user can upload a post by selecting the floating upload icon present in the main feed's bottom right corner. The image icon on the upload post activity opens up the user’s gallery and allows them to select an image and loads it up in the upload screen. User can add a description to the image in the form of a text and then go forward with it. This uploaded post is visible to all your friends in their feed as well as on your profile. 
We also use the **Image labeling** tool to detect all the objects present in the image and use the results as tags for the image. Along with using that we use **Face Detection** model provided by the Google's Firebase Machine Learning Kit to detect all the faces present in a picture and prompt the user to tag them. 

## Image Labeling (Inbuilt)
Image labeling gives you insight into the content of images. When you use the API, you get a list of the entities that were recognized: people, things, places, activities, and so on. Each label found comes with a score that indicates the confidence the ML model has in its relevance. 
We are implementing the **Image Labeling** tool to generate the dataset for our machine algorithm to work on. We are using it at the time of upload to identify all the entities present in the picture and categorize them into 3 groups based on the level of confidence. 

1. Tier 1
2. Tier 2
3. Tier 3

At the time of collecting the lables provided by the API we are also filtering out some unwanted lables that are not needed and are unsuitable for our app. After filtering all the lables and sorting them into different tiers based on their confidence value, we save those labels in the post in order to add them into the users who like the post lateron and we add these lables in the users tagged and the user uploading in various ratios to ensure we get a full understanding of what a user likes and what he doesn't like at the end of it. We are using the Cloud version of the API which gives us more accurate results and a wider array of lables. <br>
For more information about the Api - [Click Here](https://firebase.google.com/docs/ml/label-images?authuser=1)
