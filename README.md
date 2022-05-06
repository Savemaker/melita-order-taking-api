Melita-order-taking-api
How to run:
>Start the RabbitMQ with default credentials.
Example for docker-compose.yaml:
get it from [here](https://spring.io/guides/gs/messaging-rabbitmq/)

>Launch an app from Idea 

>curl -XPOST -H "Content-type: application/json" -H "X-Auth-Token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJtZWxpdGEifQ.lN9AP8sGDhdIM_Ci66y3GF1mmQVLYB7jU7BDnwIKl3Y" -d '{
"customerDetails": {
"name": "Stepan",
"surname": "Savushkin",
"installationAddress": "Cozy house in Malta",
"preferredInstallationDate": "2022-05-06",
"preferredInstallationTime": "12:05"
},
"product" : {
"internetPackage": "INTERNET_1_GBPS"
}
}' 'http://localhost:8080/melita/order'

Available products:
>internetPackage={INTERNET_250_MBPS, INTERNET_1_GBPS}, mobilePackage={MOBILE_PREPAID, MOBILE_POSTPAID}, telephonyPackage={TELEPHONY_FREE_ON_NET_CALLS, TELEPHONY_UNLIMITED_CALLS}, tvPackage={TV_90_CHANNELS,TV_140_CHANNELS}

Result
>In RabbitMQ console you will see x.accept-order exchange which will send valid order as json to q.ordering-fulfilment and q.care-system

App endpoint
>POST http://localhost:/8080/melita/order

Request header for demo purposes
>X-Auth-Token

>eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJtZWxpdGEifQ.lN9AP8sGDhdIM_Ci66y3GF1mmQVLYB7jU7BDnwIKl3Y

Request JSON body example:
>{
"customerDetails": {
"name": "Stepan",
"surname": "Savushkin",
"installationAddress": "Cozy house in Malta",
"preferredInstallationDate": "2022-05-06",
"preferredInstallationTime": "12:05"
},
"product" : {
"internetPackage": "INTERNET_1_GBPS"
}
}

The task:
Develop an authenticated Order Taking API stack that is exposed to 3rd party endpoints (example an
ERP system) selling products on behalf of Melita.

An order specifies the customer details (including personal details, installation address, preferred
installation date + time slot details), the required products (e.g. Internet, TV, Telephony, Mobile) and
the required package per product (e.g. Internet 250Mbps or 1Gbps, TV with 90 Channels or 140

Channels, Telephony with Free On net Calls or Unlimited Calls, Mobile Prepaid or Mobile Post-
paid). The Order Taking API must validate these details and accept the order. On accepting the

order it must publish a messaging event to a RabbitMQ topic for Melita's Ordering Fulfilment system
and Care systems to pick it up.

We expect the following deliverables:-
1) An authenticated public REST based Order Taking API stack.
2) Micro services to be implemented using Spring Boot
3) Publish events to a RabbitMQ
4) Code needs to be version controlled in a Git Repo
5) Expect very good code design and robust error handling, design and integration patterns
   employed
