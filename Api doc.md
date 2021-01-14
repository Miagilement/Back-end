# Catalog

## [1\. Account services](#1)
#### [1.1\. Enterprise register](#1.1)
#### [1.2\. Add contact](#1.2)
## [2\. Infomation services](#2)
#### [2.1\. Find all enterprise information](#2.1)
#### [2.2\. Find enterprise information by uid](#2.2)


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
    "enterprise":
    {
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



### Example response of succesful request

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
|nameContact    |yes   |string|name of the contact                        |
|email    |yes   |string|email of the contact                           |
|enterprise    |yes   |string|uid of the enterprise                          |


### Response class
``` javascript
BaseResVO
```

### Example request

``` javascript
{
    "contacts":[
    {
        "nameContact":"coucou",
        "email":"coucou@gmail.com",
        "enterprise":
        {
            "uid": "65e720ad-916c-426e-aa30-27453a6c102f",
            "nameEnterprise": "titi.toto",
            "password": "123456",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Girond",
            "turnOver": "0",
            "description": "Atos of the region Gironde",
            "siret": "12345678901234"
        }
    },
    {
        "nameContact":"coucou",
        "email":"coucou@gmail.com",
        "enterprise":
        {
            "uid": "65e720ad-916c-426e-aa30-27453a6c102f",
            "nameEnterprise": "titi.toto",
            "password": "123456",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Girond",
            "turnOver": "0",
            "description": "Atos of the region Gironde",
            "siret": "12345678901234"
        }
    }
]
}
```



### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": [
        {
            "id": 33,
            "nameContact": "coucou",
            "email": "coucou@gmail.com",
            "enterprise": {
                "uid": "65e720ad-916c-426e-aa30-27453a6c102f",
                "nameEnterprise": "titi.toto",
                "password": "123456",
                "groupAffiliated": "Atos",
                "sectorActivity": "informatique",
                "region": "Girond",
                "turnOver": "0",
                "description": "Atos of the region Gironde",
                "siret": "12345678901234"
            }
        },
        {
            "id": 34,
            "nameContact": "coucou",
            "email": "coucou@gmail.com",
            "enterprise": {
                "uid": "65e720ad-916c-426e-aa30-27453a6c102f",
                "nameEnterprise": "titi.toto",
                "password": "123456",
                "groupAffiliated": "Atos",
                "sectorActivity": "informatique",
                "region": "Girond",
                "turnOver": "0",
                "description": "Atos of the region Gironde",
                "siret": "12345678901234"
            }
        }
    ]
}
```

### Example response of failing request
``` javascript
{
    "code": 2,
    "message": "Wrong parameter",
    "data": 
    [
        "Le SIRET doit contenir 14 chiffres"
    ]
}
```
<h1 id="2">2. Information services</h1>
<h2 id="2.1">2.1 Find all enterprise information</h2>

### Api function
> Allow to get all information of the enterprise by its uid

### URL
> ../info/enterprise/find-by-id/{uid}

### Support format
> JSON

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
            "uid": "239ef258-d8d9-4ca0-8ae3-f6b1f5672b4a",
            "nameEnterprise": "titi.toto",
            "password": "123456",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Girond",
            "turnOver": "10M",
            "description": "Atos of the region Gironde",
            "siret": "dkjg4634634634"
        },
        {
            "uid": "09e0a9ac-bfd6-4661-9726-d7be433b9a6e",
            "nameEnterprise": "titi.toto",
            "password": "123456",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Girond",
            "turnOver": "10M",
            "description": "Atos of the region Gironde",
            "siret": "dkjg4634634634"
        },
        {
            "uid": "7459a681-0250-4bb7-ad1c-b8156641c720",
            "nameEnterprise": "titi.toto",
            "password": "123456",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Girond",
            "turnOver": "10M",
            "description": "Atos of the region Gironde",
            "siret": "dkjg4634634634"
        },
        {
            "uid": "787c43a7-da26-4537-b355-3161c547c725",
            "nameEnterprise": "titi.toto",
            "password": "123456",
            "groupAffiliated": "Atos",
            "sectorActivity": "informatique",
            "region": "Girond",
            "turnOver": "10M",
            "description": "Atos of the region Gironde",
            "siret": "dkjg4634634634"
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
../info/enterprise/find-by-id/239ef258-d8d9-4ca0-8ae3-f6b1f5672b4a
```


### Example response of succesful request

``` javascript
{
    "code": 0,
    "message": "success",
    "data": {
        "uid": "239ef258-d8d9-4ca0-8ae3-f6b1f5672b4a",
        "nameEnterprise": "titi.toto",
        "password": "123456",
        "groupAffiliated": "Atos",
        "sectorActivity": "informatique",
        "region": "Girond",
        "turnOver": "10M",
        "description": "Atos of the region Gironde",
        "siret": "dkjg4634634634"
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
