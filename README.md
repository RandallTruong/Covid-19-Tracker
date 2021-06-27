This application does not runs because the cloud based database connected to it is no longer active.
The application performed REST API calls to obtain Covid19 related data such as the number of tests, number of positive cases and 
number of deaths in all the states of the US. Once the REST call returns the requested data in JSON format, it parse the data and
displayed the results to the user. The applications also was able to save snapshots of a states's statistics to a cloud based database (Amazon AWS).
For instance, the user selects the State California. Upon clicking SAVE, the following data would be saved to the database, representing a snapshot in time:
Id, State total test results, positive cases, negative cases, death, date
