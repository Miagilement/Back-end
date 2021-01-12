# Catalog

## [1\. Account services](#1)
#### [1.1\. Enterprise register](#1.1)
#### [1.2\. Add contact](#1.2)



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
|nameEnterprise    |yes(or no if use email)    |string|enterprise|
|password    |yes    |string   |Password|
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
    "enterprise":{
    "nameEnterprise":"titi.toto",
    "password":"123456",
    "groupAffiliated":"Atos",
    "sectorActivity":"informatique",
    "region":"Girond",
    "turnOver":"10M",
    "description":"Atos of the region Gironde",
    "siret":"dkjg4634634634"
    }
}
```



Example response of succesful request

``` javascript
{
    "code":0,
    "message":"success",
    "data":
    {
        "uid":"34069839468739468"
        "name_enterprise":"titi.toto",
        "password":"123456",
        "group":"Atos"
        "secter_activity":"informatique"
        "region":"Girond"
        "turn_over":"10M"
        "description":"Atos of the region Girond"
        "num_siret ":"dkjg4634634634"
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

<h2 id="1.2">1.2 Add contact</h2>

### Api function
> Allow enterprise to add contact

### URL
> ../user/enterprise/contact/addcontact

### Support format
> JSON

### HTTP request methode
> POST

### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|nameContact    |yes(or no if use email)    |string|enterprise                          |
|email    |yes    |string   |Password|
|enterpriseUid    |yes    |string  |group name |

### Request class
``` javascript
ContactReqVO
```

### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "contacts":
    [
        {"nameContact":"coucou","email":"coucou@gmail.com","enterpriseUid":"xxx"},
        {"nameContact":"coucou","email":"coucou@gmail.com","enterpriseUid":"xxx"}
    ]
}
```



Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": [
        {
            "id": 13,
            "nameContact": "coucou",
            "email": "coucou@gmail.com",
            "enterpriseUid": "xxx"
        },
        {
            "id": 14,
            "nameContact": "coucou",
            "email": "coucou@gmail.com",
            "enterpriseUid": "xxx"
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
