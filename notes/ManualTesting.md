# Manual Testing
---

## format:

| Field            | Description                              |
| ---------------- | ---------------------------------------- |
| Test Case ID     | Unique Identifier                        |
| Test Case Title  | Short description of what is tested      |
| Module Name      | Module under test                        |
| Preconditions    | Condition before execution               |
| Test Steps       | Step-by-step actions                     |
| Test Data        | Input values                             |
| Expected Result  | Expected system behaviour                |
| Actual Result    | Actual system output                     |
| Status           | Pass/Fail                                |
| Remarks          | Additional notes                         |


## Example:
## Example

| Field            | Value |
|------------------|-------|
| Test Case ID     | TC_LOGIN_01 |
| Test Case Title  | Verify login with valid credentials |
| Module Name      | Login |
| Preconditions    | User must be registered |
| Test Steps       | 1. Open login page<br>2. Enter valid username<br>3. Enter valid password<br>4. Click login |
| Test Data        | username: admin<br>password: password@123 |
| Expected Result  | Successful login and redirect to dashboard |
| Actual Result    | Logged in and redirected to dashboard |
| Status           | Pass |
| Remarks          | Additional notes |
