# MFPE-Project-Audit-Management-System Using React

## Collaborators :

<table>
  <tr>
      <td>
        <a href="https://github.com/shubhet">Shubham Gupta</a>
        </td>
      <td>
        <a href="https://github.com/satyanpjoshi">Satyan</a>
        </td>
      <td>
        <a href="https://github.com/Harshadagangne">Harshada</a>
        </td>
    <td>
        <a href="https://github.com/e">Shubham Dalvi</a>
        </td>
    <td>
        <a href="https://github.com/">Abhishek Kumar</a>
        </td>
    </tr>
</table>

## Overview::

**How will you run this project:**
  ## Dependencies on Other microsevices : You should have Java 8 or above,maven,NPM to be installed to run this project
  Git clone the project first. Then follow the steps below :<br/>
  <tr>
  <h3>Extract Zip</h3>
  <p>Open eclips or intelj run one by one all services
  </p><br>
    </tr>
  <p> Go to postman and hit on address with post method <a href="http://localhost:9100/auth/authenticate">/authentication</a>
   <br>Enter id Passeord in body select row and in json format { "username":"userid","password":"password"}
    <br>
    Hit send wait to genrate JWT token<br>
    when token genrated in responce body copy token and go to authoriration option select <b>bearer token</b>
paste the token and enter address http://localhost:9100/auth/validate  to check token is valid or not
  <br>
  Then goto adress http://localhost:9300/checklist/AuditCheckListQuestions go to body and  enter type of audit you want to use <h5>Internal/SOX</h5> in json in body{"auditType": "Internal"} <br>
  You will get Question List
  

  

  #### Steps after getting the project in your local machine : 
  Use postman to git console responce 
    

