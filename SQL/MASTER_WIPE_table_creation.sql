DROP TABLE if exists roundHistory;
DROP TABLE if exists holes;
DROP TABLE if exists golfer_course;
DROP TABLE if exists golfer;
DROP TABLE if exists course;

create table golfer (
	golfer_id serial PRIMARY KEY,
	golfer_firstName VARCHAR(50),
	golfer_lastName VARCHAR(50),
	handedness VARCHAR(50),
	gender VARCHAR(50),
	teebox_choice VARCHAR(50),
	has_handicap boolean
	

);

create table course (
        course_id serial PRIMARY KEY,
        course_name VARCHAR(100),
        location_city VARCHAR(50),
        location_state VARCHAR(50),
        location_country VARCHAR(50),
        -- Can the below values be derived from the holes table?  Should I just do this in the app?
        par_f9 int,
        par_b9 int,
        par_18 int,
        hcap_1 int,
        hcap_2 int
        
);

CREATE TABLE holes (               -- create a method that seeds hole info from a data file if it does not already exist in db
        course_id int not null,
        hole_1 VARCHAR(100),
        hole_2 VARCHAR(100),
        hole_3 VARCHAR(100),
        hole_4 VARCHAR(100),
        hole_5 VARCHAR(100),
        hole_6 VARCHAR(100),
        hole_7 VARCHAR(100),
        hole_8 VARCHAR(100),
        hole_9 VARCHAR(100),
        hole_10 VARCHAR(100),
        hole_11 VARCHAR(100),
        hole_12 VARCHAR(100),
        hole_13 VARCHAR(100),
        hole_14 VARCHAR(100),
        hole_15 VARCHAR(100),
        hole_16 VARCHAR(100),
        hole_17 VARCHAR(100),
        hole_18 VARCHAR(100),
        
        constraint pk_holes primary key (course_id),
        constraint fk_holes_course foreign key (course_id) references course (course_id)
);

CREATE TABLE golfer_course (
        golfer_id int not null,
        course_id int not null,
        round_id serial,
        
        constraint pk_golfers_courses primary key (round_id),
        constraint fk_golfer_course_golfer foreign key (golfer_id) references golfer (golfer_id),
        constraint fk_golfer_course_course foreign key (course_id) references course (course_id)
);

CREATE TABLE roundHistory (
        round_id serial,
        handicap int,
        front_nine boolean,
        back_nine boolean,
        eighteen boolean,
        scoreString_f9 VARCHAR(50),
        scoreString_b9 VARCHAR(50),
        scoreString_18 VARCHAR(100),
        
        constraint pk_roundHistory_history primary key (round_id),
        constraint fk_roundHistory_round foreign key (round_id) references golfer_course (round_id)
);


INSERT INTO golfer (golfer_firstName, golfer_lastName, handedness, gender, teebox_choice, has_handicap) VALUES ('Michael', 'G', 'Right', 'Male', 'White', false);
INSERT INTO golfer (golfer_firstName, golfer_lastName, handedness, gender, teebox_choice, has_handicap) VALUES ('Tim', 'G', 'Right', 'Male', 'White', true);
INSERT INTO golfer (golfer_firstName, golfer_lastName, handedness, gender, teebox_choice, has_handicap) VALUES ('Bill', 'G', 'Right', 'Male', 'White', true);
INSERT INTO golfer (golfer_firstName, golfer_lastName, handedness, gender, teebox_choice, has_handicap) VALUES ('Scott', 'G', 'Right', 'Male', 'White', true);

SELECT * FROM golfer;