# Catalog

## [1\. Account register services](#1)
#### [1.1\. Enterprise register](#1.1)
#### [1.2\. Individual register](#1.2)

## [2\. Enterprise infomation services](#2)
#### [2.1\. Find all enterprise information](#2.1)
#### [2.2\. Find enterprise information by uid](#2.2)

## [3\. Individual infomation services](#3)
#### [3.1\. Find all individual information](#3.1)
#### [3.2\. Find individual information by uid](#3.2)
#### [3.3\. Update individual information](#3.2)

## [4\. Forum subject services](#4)
#### [4.1\. Find all forum subject](#4.1)
#### [4.2\. Add forum subject](#4.2)
#### [4.3\. Update forum subject](#4.3)
#### [4.4\. Find forum subject by id](#4.4)
#### [4.5\. Delete forum subject by id](#4.5)

## [5\. Forum comment services](#5)
#### [5.1\. Find all comment by subject id](#5.1)
#### [5.2\. Add forum comment](#5.2)
#### [5.3\. Update forum comment](#5.3)
#### [5.4\. Delete forum comment by id](#5.4)

<h1 id="1">1. Account services</h1>
<h2 id="1.1">1.1 Enterprise register</h2>

### Api function
> Allow enterprise to register

### URL
> ../user/enterprise/register

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|nameEnterprise    |yes    |string|enterprise|
|userPassword    |yes    |string   |Password|
|userEmail    |yes    |string   |Email|
|groupAffiliated    |yes    |string  |group name |
|secterActivity    |yes    |string  |secter activity of enterprise|
|region   |yes    |string  |region of enterprise |
|turnOver   |yes    |string  |turn over of enterprise |
|description   |yes    |string  |description of enterprise |
|siret   |yes    |string  |siret of the enterprise |

### Request class
``` javascript
EnterpriseRegisterReqVO
```

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "enterprise":
    {
        "nameEnterprise":"titi.toto",
        "userEmail":"123456",
        "userPassword":"123456",
        "groupAffiliated":"Atos",
        "sectorActivity":"informatique",
        "region":"Nouvelle d'Aquitaine",
        "turnOver":"103636",
        "description":"Atos of the region Gironde",
        "siret":"12344634634634"
    }
}
```



### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "uid": "fa9da72f-c1de-4b82-ac7f-efc574d50eef",
        "userEmail": "123456@atos.com",
        "userPassword": "$2a$10$o6lStn36iuWKhPbFYPozT.YBjpu5nhL8TIS9OtspmJwHRIhAFDYtC",
        "roles": [
            {
                "roleId": 65,
                "roleName": "USER_ENTERPRISE"
            }
        ],
        "nameEnterprise": "titi.toto",
        "groupAffiliated": "Atos",
        "sectorActivity": "informatique",
        "region": "Nouvelle d'Aquitaine",
        "turnOver": "103636",
        "description": "Atos of the region Gironde",
        "siret": "12344634634634"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h2 id="1.2">1.2 Individual register</h2>

### Api function
> Allow Individual to register

### URL
> ../user/individual/register

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|userName    |yes    |string   |User name|
|userPassword    |yes    |string   |Password|
|userEmail    |yes    |string   |Email|
|userType    |yes    |string   |User type|


### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "individual":{
    "userEmail":"atos2@gmail.com",
    "userName":"titi.toto",
    "userPassword":"123456",
    "userType":"Etudiant"
    }
}
```



### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "uid": "68ab10bd-0f88-45a4-960b-37bc072f335b",
        "userEmail": "atos2@gmail.com",
        "userPassword": "$2a$10$xqsooVNfEc0QIvwA3ML7leLPlO6wU.w7uhPn1v15Ax90JzdVQ9vY.",
        "roles": [
            {
                "roleId": 65,
                "roleName": "USER_INDIVIDUAL"
            }
        ],
        "userName": "titi.toto",
        "userType": "Etudiant"
    }
}
```

### Example response of failing request
``` javascript
{
    "code": 2,
    "message": "Wrong parameter",
    "data": {
        null
    }
}
```
<h1 id="2">2. Information services</h1>
<h2 id="2.1">2.1 Find all enterprise information</h2>

### Api function
> Allow to get all information of the enterprise

### URL
> ../info/enterprise/find-all-enterprise


### HTTP request methode
> POST

### Response class
``` javascript
BaseResVO
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": [
        {
            "uid": "66c81ae9-ec34-4c08-824a-e786cfe979f4",
            "userEmail": "atos@gmail.com",
            "nameEnterprise": "titi.toto",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Girond",
            "turnOver": "0",
            "description": "Atos of the region Gironde",
            "siret": "12345678901237"
        },
        {
            "uid": "fa9da72f-c1de-4b82-ac7f-efc574d50eef",
            "userEmail": "123456@atos.com",
            "nameEnterprise": "titi.toto",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Nouvelle d'Aquitaine",
            "turnOver": "103636",
            "description": "Atos of the region Gironde",
            "siret": "12344634634634"
        }
    ]
}
```

### Example response of failing request
``` javascript
{
    "code":-1,
    "message":"Seems problem, please try later",
    "data":
    {
        null
    }
}
```

<h2 id="2.2">2.2 Find enterprise information by uid</h2>

### Api function
> Allow to get all information of the enterprise by its uid

### URL
> ../info/enterprise/find-by-id/{uid}

### Support format
> RESTful

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|uid   |yes   |string|uid of enterprise                         |



### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../info/enterprise/find-by-id/fa9da72f-c1de-4b82-ac7f-efc574d50eef
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "uid": "fa9da72f-c1de-4b82-ac7f-efc574d50eef",
        "userEmail": "123456@atos.com",
        "nameEnterprise": "titi.toto",
        "groupAffiliated": "Atos",
        "sectorActivity": "informatique",
        "region": "Nouvelle d'Aquitaine",
        "turnOver": "103636",
        "description": "Atos of the region Gironde",
        "siret": "12344634634634"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h1 id="3">3 Individual information service</h1>
<h2 id="3.1">3.1 Find all individual information</h2>

### Api function
> Allow to get all information of the individual

### URL
> ../info/individual/find-all-individual

### HTTP request methode
> POST

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../info/individual/find-all-individual
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": [
        {
            "uid": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "userEmail": "atos@gmail.com",
            "userName": "titi.toto",
            "userType": "Etudiant"
        },
        {
            "uid": "68ab10bd-0f88-45a4-960b-37bc072f335b",
            "userEmail": "atos2@gmail.com",
            "userName": "titi.toto",
            "userType": "Etudiant"
        }
    ]
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h2 id="3.2">3.2 Find individual information by uid</h2>

### Api function
> Allow to get information of the individual by his id

### URL
> ../info/individual/find-by-id/68ab10bd-0f88-45a4-960b-37bc072f335b

### HTTP request methode
> POST


### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../info/individual/find-by-id/68ab10bd-0f88-45a4-960b-37bc072f335b
```


### Example response of succesful request
``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "uid": "68ab10bd-0f88-45a4-960b-37bc072f335b",
        "userEmail": "atos2@gmail.com",
        "userName": "titi.toto",
        "userType": "Etudiant"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h2 id="3.3">3.3 Find all individual information</h2>

### Api function
> Allow individual user to update his information

### URL
> ../info/individual/update-individual-info

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|uid   |yes   |string|uid of enterprise                         |
|userName   |yes   |string|user name                      |
|userEmail   |yes   |string|user email                       |
|userPassword  |yes   |string|user password                      |
|userType   |yes   |string|user type                        |

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "individual":{
    "uid":"68ab10bd-0f88-45a4-960b-37bc072f335b",
    "userEmail":"atos2@gmail.com",
    "userName":"Jean-Pierre",
    "userPassword":"123456",
    "userType":"Etudiant"
    }
}
```

### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "uid": "68ab10bd-0f88-45a4-960b-37bc072f335b",
        "userEmail": "atos2@gmail.com",
        "userName": "Jean-Pierre",
        "userType": "Etudiant"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h1 id="4">4 Forum subject service</h1>
<h2 id="4.1">4.1 Find all forum subject</h2>

### Api function
> Allow to get all subject of the forum

### URL
> ../forum/find-all-forum-subjects

### HTTP request methode
> POST

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../forum/find-all-forum-subjects
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": [
        
        {
            "id": 76,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:52.537+00:00",
            "dateLastModified": "2021-02-01T10:04:52.537+00:00"
        },
        {
            "id": 77,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:53.202+00:00",
            "dateLastModified": "2021-02-01T10:04:53.202+00:00"
        },
        {
            "id": 78,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:53.714+00:00",
            "dateLastModified": "2021-02-01T10:04:53.714+00:00"
        },
        {
            "id": 79,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:54.142+00:00",
            "dateLastModified": "2021-02-01T10:04:54.141+00:00"
        },
        {
            "id": 80,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:54.563+00:00",
            "dateLastModified": "2021-02-01T10:04:54.562+00:00"
        },
        {
            "id": 81,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:54.927+00:00",
            "dateLastModified": "2021-02-01T10:04:54.927+00:00"
        },
        {
            "id": 82,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:55.302+00:00",
            "dateLastModified": "2021-02-01T10:04:55.301+00:00"
        },
        {
            "id": 83,
            "title": "coucou",
            "text": "coucou@gmail.com",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "datePost": "2021-02-01T10:04:55.674+00:00",
            "dateLastModified": "2021-02-01T10:04:55.673+00:00"
        }
    ]
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h2 id="4.2">4.2 Add forum subject</h2>

### Api function
> Allow to add a subject for the forum

### URL
> ../forum/add-forum-subject

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|title   |yes   |string|uid of enterprise                         |
|text   |yes   |string|user name                      |

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "forumSubject":
    {
        "title":"coucou",
        "text":"coucou@gmail.com",
        "authorId":"33732473-654d-440b-8d4e-e8ad9e44f786"
    }
}
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 84,
        "title": "coucou",
        "text": "coucou@gmail.com",
        "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
        "datePost": "2021-02-01T10:09:50.818+00:00",
        "dateLastModified": "2021-02-01T10:09:50.818+00:00"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h2 id="4.3">4.3 Update forum subject</h2>

### Api function
> Allow to update a subject for the forum

### URL
> ../forum/update-forum-subject

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|title   |yes   |string|uid of enterprise                         |
|text   |yes   |string|user name                      |

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "forumSubject":
    {
        "id":84,
        "title":"chouchou",
        "text":"coucou@gmail.com"
    }
}
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 84,
        "title": "chouchou",
        "text": "coucou@gmail.com",
        "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
        "datePost": "2021-02-01T10:09:50.818+00:00",
        "dateLastModified": "2021-02-01T10:15:56.705+00:00"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```


<h2 id="4.4">4.4 Find forum subject by id</h2>

### Api function
> Allow to find a subject by its id

### URL
> ../forum/find-forum-subject-by-id/{id}

### Support format
> RESTful

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|id   |yes   |string|id of subject                        |

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../forum/find-forum-subject-by-id/84
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 84,
        "title": "chouchou",
        "text": "coucou@gmail.com",
        "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
        "datePost": "2021-02-01T10:09:50.818+00:00",
        "dateLastModified": "2021-02-01T10:15:56.705+00:00"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":-1,
    "message":"Seems problem, please try later",
    "data":
    {
        null
    }
}
```

<h2 id="4.5">4.5 Delete forum subject by id</h2>

### Api function
> Allow to delete a subject by its id

### URL
> ../forum/delete-forum-subject-by-id/{id}

### Support format
> RESTful

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|id   |yes   |string|id of subject                        |

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../forum/delete-forum-subject-by-id/84
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": null
}
```

### Example response of failing request
``` javascript
{
    "code":-1,
    "message":"Seems problem, please try later",
    "data":
    {
        null
    }
}
```

<h1 id="5">5 Forum comment service</h1>
<h2 id="5.1">5.1 Find all comment by subject id</h2>

### Api function
> Allow to get all comment of the forum subject

### URL
> ../forum/comment/find-comment-by-subject/{subjectId}

### Support format
> RESTful

### HTTP request methode
> POST


### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../forum/comment/find-comment-by-subject/80
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": [
        {
            "id": 86,
            "subjectId": 80,
            "text": "Hello",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "dateComment": "2021-02-01T10:34:38.424+00:00",
            "dateLastModified": "2021-02-01T10:34:38.417+00:00"
        },
        {
            "id": 87,
            "subjectId": 80,
            "text": "Hello",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "dateComment": "2021-02-01T10:34:53.434+00:00",
            "dateLastModified": "2021-02-01T10:34:53.434+00:00"
        },
        {
            "id": 88,
            "subjectId": 80,
            "text": "Hello",
            "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
            "dateComment": "2021-02-01T10:34:54.075+00:00",
            "dateLastModified": "2021-02-01T10:34:54.075+00:00"
        }
    ]
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h2 id="5.2">5.2 Add forum comment</h2>

### Api function
> Allow to add a comment to a subject

### URL
> ../forum/comment/add-forum-comment

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|subjectId   |yes   |string|id of the subject                         |
|text   |yes   |string|comment                      |
|authorId  |yes   |string|uid of the author                   |

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "forumComment" :
    {
        "id": 80,
        "text": "Hello",
        "authorId" : "33732473-654d-440b-8d4e-e8ad9e44f786"
    }
}
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 89,
        "subjectId": 80,
        "text": "Hello",
        "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
        "dateComment": "2021-02-01T10:37:33.766+00:00",
        "dateLastModified": "2021-02-01T10:37:33.766+00:00"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```

<h2 id="5.3">5.3 Update forum comment</h2>

### Api function
> Allow to update a comment of a subject

### URL
> ../forum/update-comment

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|Id   |yes   |string|id of the comment                        |
|text   |yes   |string|comment                                |
|authorId  |yes   |string|uid of the author                   |

### Response class
``` javascript
BaseResVO
```

### Example request
``` javascript
{
    "forumComment" :
    {
        "id": 87,
        "text": "Helloooooooooooo"
    }
}
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 87,
        "subjectId": 80,
        "text": "Helloooooooooooo",
        "authorId": "33732473-654d-440b-8d4e-e8ad9e44f786",
        "dateComment": "2021-02-01T10:34:53.434+00:00",
        "dateLastModified": "2021-02-01T10:34:53.434+00:00"
    }
}
```

### Example response of failing request
``` javascript
{
    "code":2,
    "message":"Wrong parameter",
    "data":
    {
        null
    }
}
```


<h2 id="5.4">5.4 Delete forum comment by id</h2>

### Api function
> Allow to delete a comment by its id

### URL
> ../forum/delete-forum-comment/{id}

### Support format
> RESTful

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|id   |yes   |string|id of comment                        |

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
../forum/delete-forum-comment/89
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": null
}
```

### Example response of failing request
``` javascript
{
    "code":-1,
    "message":"Seems problem, please try later",
    "data":
    {
        null
    }
}
```
