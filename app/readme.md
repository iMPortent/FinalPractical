- The only part I had trouble with was getting the individual images to load on the breeed activity.
Multiple retrofit calls just overloaded the UI thread. I tried different methods, but the last resort was have an
AsyncTask in the background that took all the data while you logged in so i had all od the images pre loaded.
But I am satisfied with what I have so fat
