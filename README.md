# Lambda boilerplate (scala)

## Features
* A lambda skeleton written in scala
* Provides an example cloudformation stack
* The lambda is triggered daily via an event _(you probably want to change that)_
* Uses the new `riff-raff.yaml`
* Automatically deploys the cloudformation via riff-raff

## Using this template
No need to pull the project anymore, ensure you have at least sbt 13.13, then run
`sbt new guardian/lambda-scala-boilerplate`

## Test locally
use `sbt run` to test your lambda

## Set-up the build
Set up your favourite continuous integration system to run `clean compile test riffRaffUpload`

## Deploy for the first time
1. Upload the artifact using riff-raff. To do so, click [here](https://riffraff.gutools.co.uk/deployment/request), pick your project and build, then click on "Preview" .
2. In the preview screen, only select the `s3upload` task
3. Once uploaded, connect to aws and create the cloudformation stack. Don't forget to tag your cloudformation stack [like so](https://i.imgur.com/P03Ofci.png)
4. Go back to [riff-raff](https://riffraff.gutools.co.uk/deployment/request) and use the standard deploy



