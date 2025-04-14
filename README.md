Assumption #1  
For coding exercise purpose, all the layers i.e. repository or service/component layer were intentionally omitted. 
No records usage, only classes. Normally separate entities such as match, team (country) should have own identifiers and 
timestamps of creation/update - here this is omitted.

Assumption #2  
None of the team cannot be registered in a new match as a home/away team when already registered in a match that's in progress.

Assumption #3  
Only one team from one country.

Assumption #4
Match cannot be registered with only one team, team with empty country, homeTeamCountry == awayTeamCountry, team with to long 
countryName or wit countryName containing special chars. nput teams validation is placed as soon as possible, 
when starting match. Imo team validation should be placed when creating the team by the dedicated entry point.

Assumption #5  
For coding exercise purposes (keeping it simple) any additional match information such as an additional 
time, cards, team members, scoring players were intentionally omitted.  

Assumption #6  
For coding exercise purposes (keeping it simple) there are no additional objects introduced (daos, dtos, entities, dbitems).