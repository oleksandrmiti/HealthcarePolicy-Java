### HealtcarePolicy-Java
## Second assignment in Java at Cork College of Commerece.<br>
Program Specification
HCI Healthcare policies are priced as follows:
•
•
The annual cost of basic healthcare for one person is €426. This includes insurance as an outpatient, for one person, aged between 18 and 50 (inclusive). People under 18 cannot buy a policy directly but can be a dependant on a policy. A person who is over 50 will be subject to an additional charge of €80.
Insurance for dependants on the same policy costs as follows:
- 1st dependant: €250
- 2nd dependant: €150
- 3rd dependant: €100
- 4th dependant: €50
Additional dependants are free, up to a maximum of 6 dependants in total.
Each dependant’s name and age must be on the policy and each dependant must be under 18 years of age.
Inpatient insurance costs an additional €200. This includes insurance for a semi-private room. Insurance for a private room costs €100 extra.
A customer can avail of 0, 1 or 2 of the following extras:
- Orthopaedic care
- Ophthalmic care
- Maternity care
- Fertility care
- Psychiatric care
Each additional extra costs €50.
• •
You are required to design, code and test an object oriented solution that will read in the details of a prospective insurer, calculate the cost of their health insurance, and output a quotation in the format shown below. The program is to run until there are no further quotations to be made.
<br>

![image](https://github.com/oleksandrmiti/HealthcarePolicy-Java/assets/114529427/fdc90a80-3619-44e9-aa5c-b59533ccdb50)
<br>
Notes:
 
 



• VAT is payable at 21%.
• User input is to be checked to ensure that it is correct (e.g. ensure that the number of dependents is between 0 and 6 inclusive, make sure that choices e.g. inpatient care or not, are valid etc.)
• The border for the policy quotation is for illustration only and need not be drawn.
• Basic cost is €426 or €426 + €80 as outlined in the first paragraph of the narrative.
• For inpatient cost, output “Yes” if the person is buying inpatient insurance, output “No” if the person is not buying inpatient insurance.
• For room type, output “NA” if the person is not buying inpatient insurance (with a cost of €0), otherwise output “Private” or “Semi-Private” as appropriate and with the relevant cost.
• For additional extras, output “None” if the person is not paying for additional insurance extras, otherwise output a list of the additional extras that the person buying insurance for.
• VAT is payable at 21%.
• All monetary values are to be suitably formatted.
