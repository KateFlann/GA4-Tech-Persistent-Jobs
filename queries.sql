--Part 1
SELECT * FROM techjobs.job;

--Part 2
SELECT name FROM employer WHERE location = "St. Louis City";

--Part 3
DROP TABLE job;

--Part 4

SELECT * FROM skill
LEFT JOIN job_skills ON job_skills.skill_id = skills.skill_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC

--write a query to return the names of all skills that are attached to jobs in alphabetical order.
--If a skill does not have a job listed, it should not be included in the results of this query.