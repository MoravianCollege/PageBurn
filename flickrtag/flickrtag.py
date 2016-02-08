#This program makes use of the flickr api, and searches for the images under the user specified tag. The response
#message is then stripped and turned into from JSON into a dictionary. The first element is the most popular with that
#tag, and we then call upon the flickr api again with an http request to give us the url of the most popular picture for
#the specified tag.

import json, requests


def main():

    photoID = ""
    photoURL = ""
    url = "https://api.flickr.com/services/rest"

    # Prompt user to input a tag
    tagInput = input("Enter the tag you would like to search for: ")

    # Prepare query to retrieve photo's based on input
    payload1 = {'api_key': '9a69979ebccf5cb054ee3c571720f052', 'method': 'flickr.photos.search', 'tags': tagInput,
                'format': 'json'}

    # Query data based on tag input
    response = requests.get(url, params=payload1)

    # Remove the beginning and end part of data since it is causing errors
    response = stripExcess(response)


    # Store id of first photo from the response data
    photoID = response["photos"]['photo'][000]['id']

    # Prepare second query to retrieve photo's url
    payload2 = {'api_key': '9a69979ebccf5cb054ee3c571720f052', 'method': 'flickr.photos.getInfo', 'photo_id': photoID,
                'format': 'json'}
    # Query photo data
    response = requests.get(url, params=payload2)

    # Remove the beginning and end part of data since it is causing errors
    response = stripExcess(response)

    # Store photo url for output (might not need)
    photoURL = response['photo']['urls']['url'][0]['_content']

    # Print the url
    print(photoURL)

# This function removes the "jsonapi(" from the beginning and ")"
# from the end of the query response as it apparently disrupts the
# JSON decoding process
def stripExcess(resp):
    resp = json.loads((resp.content).decode().partition('(')[-1].rpartition(')')[0])
    return resp


if __name__ == '__main__':
    main()
