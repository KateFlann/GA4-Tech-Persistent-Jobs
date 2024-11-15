--Part 1
SELECT * FROM techjobs.job;

--Part 2
SELECT name FROM employer WHERE location = "St. Louis City";

--Part 3
DROP TABLE job;

--Part 4


--LEFT JOIN pen_drawer ON writing_supply.supply_id = pen_drawer.supply_id;

SELECT *
FROM skill
LEFT JOIN job ON skills.skills_id =  job.skills_id
WHERE isNotNull(job_skills);
ORDER BY ASC

--write a query to return the names of all skills that are attached to jobs in alphabetical order.
--If a skill does not have a job listed, it should not be included in the results of this query.