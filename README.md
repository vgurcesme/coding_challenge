<h1>About The App</h1>
A java app filters a given track keywords through Twitter Stream.<br>
<a href="https://github.com/yusuke/twitter4j" target="_blank">Twitter4j</a> open source project is being used for the integration through Twitter.<br>
It is extended for limiting the incoming messages for XX seconds or up to XX messages, whichever happens first.<br>
Users sorted chronologically, ascending <br>
The messages per user should  is sorted chronologically, ascending<br>
The result is saved to a log file.
<h3>The output columns are in that order</h3> 
The user ID<br>
The creation date of the user as epoch value<br>
The name of the user<br>
The screen name of the user<br>
The message ID<br>
The creation date of the message as epoch value<br>
The text of the message<br>

<h3>Output Sample Data</h3> 
552745573	1334327588000	An20na	xxxxannaaa	972784232501301248	1520764809000	Aww the kids are so happy 😊 Roger's kindness is killing me 😭💕 https://t.co/e6sACUbFFh<br>
853835504210464768	1492405222000	nakul _mehta17. Love IB fam	Naksm17	972784327091261440	1520764831000	RT @alekhsangal: The most talented father-son duo are feeling inspired by @rogerfederer 's 20 Grand Slam wins, #RF20... And are touched by…


<h1>Set Up</h1>
<h2>Create Twitter App</h2>
<ol>
  <li>You need to register your application at : https://apps.twitter.com</li>
  <li>Advised to set Access Level To Read-only. You can change afterwards in case more permission required</li>
  <li>Navigate to Keys and Access Tokens Tab</li>
  <li>You will see Consumer Key (API Key) and Consumer Secret (API Secret)</li>
  <li>Copy them to twitter4j.properties file</li>
  <li>Crate Access Token from the same page </li>
  <li>Copy Access Token and Access Token Secret to twitter4j.properties file</li>
</ol>  

Your twitter4j.properties file should look like </br>
oauth.consumerKey=XX</br>
oauth.consumerSecret=XX</br>
oauth.accessToken=XX</br>
oauth.accessTokenSecret=XX

<h2>Configure App</h2>
All configuration parameters are at the codingchallenge.properties file <br>
The defaults are listed below<br>
http.stream.timelimit=30<br>
http.stream.maximumrecords=100<br>
<h1>Run The App</h1>
Usage: java com.ing.interview.codingchallenge.app [track keyword]
