# Lambda boilerplate (scala)

## Customise
1. Clone the repository
2. Change the `name` value in `build.sbt`
3. In `cfn.yaml` set sensible values for the `App`, `Stack` and `DeployBucket`
3. Search and replace `lambda-scala-boilerplate` with the name of your lambda in `riff-raff.yaml`
4. In `riff-raff.yaml` set values for `stacks`, `regions` and `bucket`

## Test locally
use `sbt run` to test your lambda

## Set-up the build
Set up your favourite continuous integration system to run `clean compile test riffRaffUpload`

## Deploy for the first time
1. Upload the artifact using riff-raff. To do so, click [here](https://riffraff.gutools.co.uk/deployment/request), pick your project and build, then click on "Preview" .
2. In the preview screen, only select the `s3upload` task
3. Once uploaded, connect to aws and create the cloudformation stack. Don't forget to tag your cloudformation stack [like so](https://i.imgur.com/P03Ofci.png)
4. Go back to [riff-raff](https://riffraff.gutools.co.uk/deployment/request) and use the standard deploy



