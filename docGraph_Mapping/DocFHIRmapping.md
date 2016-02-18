#DocGraph to FHIR mapping
The following document is intended to be our interactive mapping from docgraph to FHIR fields.

###A note about the DocGraph Fields
These were all taken from the CMS documentation for the medicare data that has been shared with us.
If there are any fields in other parts of the data that were missed, please feel free to add them.
Also, if there is disagreement about a field mapping, feel free to make a note of it or change it.

##DocGraph Field Definitions Straight from Documentation. 

**npi** \- National Provider Identifier (NPI) for the performing provider on the claim.

**nppes\_provider\_last\_org\_name** \- When the provider is registered in NPPES as an individual (entity type 
code= 'I'), this is the provider's last name. When the provider is registered as an organization (entity type 
code = 'O'), this is the organization name.

**nppes\_provider\_first\_name** \- When the provider is registered in NPPES as an individual (entity type 
code='I'), this is the provider's first name. When the provider is registered as an organization (entity 
type code = 'O'), this will be blank.

**nppes\_provider\_mi** \- When the provider is registered in NPPES as an individual (entity type code='I'), 
this is the provider's middle initial. When the provider is registered as an organization (entity type code 
= 'O'), this will be blank.

**nppes\_credentials** \- When the provider is registered in NPPES as an individual (entity type code='I'), 
these are the provider's credentials. When the provider is registered as an organization (entity type 
code = 'O'), this will be blank.

**nppes\_provider\_gender** \- When the provider is registered in NPPES as an individual (entity type 
code='I'), this is the provider's gender. When the provider is registered as an organization (entity type 
code = 'O'), this will be blank.

**nppes\_entity\_code** \- Type of entity reported in NPPES. An entity code of 'I' identifies providers 
registered as individuals and an entity type code of 'O' identifies providers registered as organizations.

**nppes\_provider\_street1** \- The first line of the provider's street address, as reported in NPPES.

**nppes\_provider\_street2** \- The second line of the provider's street address, as reported in NPPES.

**nppes\_provider\_city** \- The city where the provider is located, as reported in NPPES.

**nppes\_provider\_zip** \- The provider's zip code, as reported in NPPES.

**nppes\_provider\_state** \- The state where the provider is located, as reported in NPPES. The fifty U.S. 
states and the District of Columbia are reported by the state postal abbreviation. 

###The following values are used for other areas:

'XX' = 'Unknown'

'AA' = 'Armed Forces Central/South America'

'AE' = 'Armed Forces Europe'

'AP' = 'Armed Forces Pacific'

'AS' = 'American Samoa'

'GU' = 'Guam'

'MP' = 'North Mariana Islands'

'PR' = 'Puerto Rico'

'VI' = 'Virgin Islands'

'ZZ' = 'Foreign Country'

**nppes\_provider\_country** \- The country where the provider is located, as reported in NPPES. The country 
code will be 'US' for any state or U.S possession. For foreign countries (i.e., state values of 'ZZ'), 
###The provider country values include the following:

'AE' = 'United Arab Emirates' 'IL'= 'Israel'

'AR'= 'Argentina' 'IN'= 'India'

'AU'= 'Australia' 'IS'= 'Iceland'

'BR'= 'Brazil' 'IT'= 'Italy'

'CA'= 'Canada' 'JP'= 'Japan'

'CH'= 'Switzerland' 'KR'= 'Korea'

'CN'= 'China' 'NL'= 'Netherlands'

'CO'= 'Colombia' 'PK'= 'Pakistan'

'DE' = 'Germany' 'SA' = 'Saudi Arabia'

'ES'= 'Spain' 'SY'= 'Syria'

'FR'= 'France' 'TR'= 'Turkey'

'GB'= 'Great Britain' 'VE'= 'Venezuela'

'HU'= 'Hungary'

**provider\_type** \- Derived from the provider specialty code reported on the claim. For providers that 
reported more than one specialty code on their claims, this is the specialty code associated with the 
largest number of services.

**medicare\_participation\_indicator** \- Identifies whether the provider participates in Medicare and/or 
accepts assignment of Medicare allowed amounts. The value will be 'Y' for any provider that had at 
least one claim identifying the provider as participating in Medicare or accepting assignment of 
Medicare allowed amounts.

**place\_of\_service** \- Identifies whether the place of service submitted on the claims is a facility (value of 
'F') or non-facility (value of 'O'). Non-facility is generally an office setting; however other entities are 
included in non\-facility. See Appendix B \- Place of Service Descriptions for the types of entities
included in facility and non\-facility.

**hcpcs\_code** \- HCPCS code for the specific medical service furnished by the provider.

**hcpcs\_description** \- Description of the HCPCS code for the specific medical service furnished by the 
provider.

**line\_srvc\_cnt** \- Number of services provided; note that the metrics used to count the number provided 
can vary from service to service.

**bene\_unique\_cnt** \- Number of distinct Medicare beneficiaries receiving the service.

**bene\_day\_srvc\_cnt** \- Number of distinct Medicare beneficiary/per day services. Since a given 
beneficiary may receive multiple services of the same type (e.g., single vs. multiple cardiac stents) on a 
single day, this metric removes double-counting from the line service count to identify whether a unique 
service occurred.

**average\_Medicare\_allowed\_amt** \- Average of the Medicare allowed amount for the service; this figure 
is the sum of the amount Medicare pays, the deductible and coinsurance amounts that the beneficiary is 
responsible for paying, and any amounts that a third party is responsible for paying.

**stdev\_Medicare\_allowed\_amt** \- Standard deviation of the Medicare allowed amounts. The standard 
deviation indicates the amount of variation from the average Medicare allowed amount that exists 
within a single provider, HCPCS service, and place of service.

**average\_submitted\_chrg\_amt** \- Average of the charges that the provider submitted for the service.

**stdev\_submitted\_chrg\_amt** \- Standard deviation of the charge amounts submitted by the provider. The 
standard deviation indicates the amount of variation from the average submitted charge amount that 
exists within a single provider, HCPCS service, and place of service.

**average\_Medicare\_payment\_amt** \- Average amount that Medicare paid after deductible and 
coinsurance amounts have been deducted for the line item service.

**stdev\_Medicare\_payment\_amt** \- Standard deviation of the Medicare payment amount. The standard 
deviation indicates the amount of variation from the average Medicare payment amount that exists 
within a single provider, HCPCS service, and place of service.

##Link To FHIR resources
* [Practitioner](https://www.hl7.org/fhir/practitioner.html).

* [DiagnosticReport](https://www.hl7.org/fhir/diagnosticreport.html) See descriptions, use and boundaries and relationships for groups of patients and use with observations.

* [Observation](https://www.hl7.org/fhir/observation.html)

##Mapping so far from DocGraph to FHIR
**npi** --> [Practitioner.identifier](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.identifier)

**nppes\_provider\_last\_org\_name**, **nppes\_provider\_first\_name**, **nppes\_provider\_mi** --> [Practitioner.Name](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.name).
* For the above link, also note that the UML for Practitioner says name can be [HumanName](https://www.hl7.org/fhir/datatypes.html#HumanName)

**nppes\_credentials** --> [Practitioner.qualification](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.qualification)

**nppes\_provider\_gender** --> [Practitioner.gender(https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.gender)

**nppes\_entity\_code** --> [Practitioner.identifier](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.identifier) This can also be an identifier, the UML shows we can have many identifiers.
* Other ideas include putting this in as an extension or not even make resources from data with entity code 'O' as this means organization, even though practitioner supports this.

**nppes\_provider\_street1**, **nppes\_provider\_street2**, **nppes\_provider\_city**, **nppes\_provider\_zip**, **nppes\_provider\_state** **nppes\_provider\_country** --> [Practitioner.address](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.address)

**provider\_type** --> [Practitioner.practitionerRole.specialty](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.practitionerRole.specialty)

**medicare\_participation\_indicator** --> Extension?

**place\_of\_service** --> [Practitioner.practitionerRole.ManagingOrganization](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.practitionerRole.managingOrganization)

**hcpcs\_code**, **hcpcs\_description** --> [Practitioner.practitionerRole.healthCareService](https://www.hl7.org/fhir/practitioner-definitions.html#Practitioner.practitionerRole.healthcareService)
* Also take note about the code in the above line. In the link find Practitioner.qualification.code, there is a 1:1 requirement for all qualifications and codes for them.

**line\_srvc\_cnt**, **bene\_unique\_cnt**, **bene\_day\_srvc\_cnt**  --> No exact field for these. This is where the Diagnostic Reports and Observations come in. Possible Extension?

**average\_Medicare\_allowed\_amt**,**stdev\_Medicare\_allowed\_amt**, **average\_Medicare\_payment\_amt**, **stdev\_Medicare\_payment\_amt** --> I'm thinking that all of the medicare stuff can be a medicare extension on Practitioner

**average\_submitted\_chrg\_amt**, **stdev\_submitted\_chrg\_amt** --> These don't seem to have anything to do with a Practitioner, which is another reason to possibly use the Observerations and Diagnostic Reports.

##Ideas
So far we have two general ideas for how to fill the resources
###Extensions
* The first idea is to use extensions on practitioner. This would give us the benifit of only having one resource per line of DocGraph Data. 
* The problem with it is that now it makes some of the data harder to get at. For example, a few of the fields seem to be more about specific procedures rather than the practitioner itself.
* Also if we are trying to have a practitioner be just a practitioner, then by stuffing it with extensions we now made it be a practitioner that also holds some medicare data as well as medical procedure data.
###Multiple Resources
* Our second idea is to split the data up into a few different resources.
* The bulk of the data can go into the Practitioner resource as shown above. 
* The aggregate data about the procedures can go into Diagnostic Report Resources which have a reference to the administering practitioner. 
* The medicare data does somewhat have more to do with the practitioner so we can add that as a 'medicare extension' to the practitioner ny making use of the extensible nature of FHIR.




