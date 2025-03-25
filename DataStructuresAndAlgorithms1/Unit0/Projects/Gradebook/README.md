Date Created: September 27, 2022
Last Date Edited: October 6, 2022

Teachers can create students, assessment types and weight, and students grades

Gradebook.java:
This program is interactive and allows the user to edit blocks, students, assessment types and their weight, and create scores for assessments.
The user can view letter averages for each student, assessments. This program can save all information to be reopened later.

Block.java:
Block class, holds student roster and allows user to edit assessment types and their weight. Also shows student's averages

Student.java:
Student class containing data for grades, sectioned by assessment type. Also contains student's grade, and average.
User can edit all the above information, except assessment type (edited in the block class)

GradeType.java:
Stores information about each asssessment type. Contains assessment type's name and weight. Holds assessments of this type (accessible)

Assessment.java:
This class stores information (name and grade) about each assessment.
