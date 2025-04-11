CREATE TABLE attendee
(
    id           UUID NOT NULL,
    user_id      UUID,
    hackathon_id UUID,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_attendee PRIMARY KEY (id)
);

CREATE TABLE check_in
(
    id         UUID NOT NULL,
    hacker_id  UUID,
    event_id   UUID,
    timestamp  TIMESTAMP WITHOUT TIME ZONE,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_checkin PRIMARY KEY (id)
);

CREATE TABLE evaluation
(
    id            UUID NOT NULL,
    judge_id      UUID,
    submission_id UUID,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_evaluation PRIMARY KEY (id)
);

CREATE TABLE event
(
    id          UUID NOT NULL,
    name        VARCHAR(255),
    start_date  TIMESTAMP WITHOUT TIME ZONE,
    end_date    TIMESTAMP WITHOUT TIME ZONE,
    description VARCHAR(255),
    location    VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_event PRIMARY KEY (id)
);

CREATE TABLE hackathon
(
    id         UUID NOT NULL,
    name       VARCHAR(255),
    website    VARCHAR(255),
    year       VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_hackathon PRIMARY KEY (id)
);

CREATE TABLE hacker
(
    id           UUID NOT NULL,
    attendee_id  UUID,
    team_id      UUID,
    hackathon_id UUID,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_hacker PRIMARY KEY (id)
);

CREATE TABLE judge
(
    id         UUID NOT NULL,
    user_id    UUID,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_judge PRIMARY KEY (id)
);

CREATE TABLE judge_assignment
(
    id         UUID NOT NULL,
    judge_id   UUID,
    track_id   UUID,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_judgeassignment PRIMARY KEY (id)
);

CREATE TABLE organizer
(
    id           UUID NOT NULL,
    attendee_id  UUID,
    hackathon_id UUID,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_organizer PRIMARY KEY (id)
);

CREATE TABLE project
(
    id          UUID NOT NULL,
    name        VARCHAR(255),
    team_id     UUID,
    description VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

CREATE TABLE resource
(
    id         UUID         NOT NULL,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    sender_id  UUID         NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_resource PRIMARY KEY (id)
);

CREATE TABLE resource_recipients
(
    id             UUID         NOT NULL,
    resource_id    UUID         NOT NULL,
    attendee_id    UUID,
    team_id        UUID,
    recipient_type VARCHAR(255) NOT NULL,
    CONSTRAINT pk_resource_recipients PRIMARY KEY (id)
);

CREATE TABLE sponsor
(
    id             UUID NOT NULL,
    user_id        UUID,
    sponsor_org_id UUID,
    created_at     TIMESTAMP WITHOUT TIME ZONE,
    updated_at     TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_sponsor PRIMARY KEY (id)
);

CREATE TABLE sponsor_org
(
    id         UUID NOT NULL,
    name       VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_sponsororg PRIMARY KEY (id)
);

CREATE TABLE submission
(
    id           UUID NOT NULL,
    project_id   UUID,
    track_id     UUID,
    submitted_at TIMESTAMP WITHOUT TIME ZONE,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_submission PRIMARY KEY (id)
);

CREATE TABLE team
(
    id           UUID NOT NULL,
    name         VARCHAR(255),
    hackathon_id UUID,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_team PRIMARY KEY (id)
);

CREATE TABLE track
(
    id          UUID NOT NULL,
    name        VARCHAR(255),
    sponsor_id  UUID,
    description VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_track PRIMARY KEY (id)
);

CREATE TABLE "user"
(
    id UUID NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE attendee
    ADD CONSTRAINT uc_de2b359be742d8f6ecb8ff599 UNIQUE (user_id, hackathon_id);

ALTER TABLE hacker
    ADD CONSTRAINT uc_hacker_attendee UNIQUE (attendee_id);

ALTER TABLE organizer
    ADD CONSTRAINT uc_organizer_attendee UNIQUE (attendee_id);

ALTER TABLE project
    ADD CONSTRAINT uc_project_team UNIQUE (team_id);

ALTER TABLE sponsor
    ADD CONSTRAINT uc_sponsor_user UNIQUE (user_id);

ALTER TABLE attendee
    ADD CONSTRAINT FK_ATTENDEE_ON_HACKATHON FOREIGN KEY (hackathon_id) REFERENCES hackathon (id);

ALTER TABLE attendee
    ADD CONSTRAINT FK_ATTENDEE_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE check_in
    ADD CONSTRAINT FK_CHECKIN_ON_EVENT FOREIGN KEY (event_id) REFERENCES event (id);

ALTER TABLE check_in
    ADD CONSTRAINT FK_CHECKIN_ON_HACKER FOREIGN KEY (hacker_id) REFERENCES hacker (id);

ALTER TABLE evaluation
    ADD CONSTRAINT FK_EVALUATION_ON_JUDGE FOREIGN KEY (judge_id) REFERENCES judge (id);

ALTER TABLE evaluation
    ADD CONSTRAINT FK_EVALUATION_ON_SUBMISSION FOREIGN KEY (submission_id) REFERENCES submission (id);

ALTER TABLE hacker
    ADD CONSTRAINT FK_HACKER_ON_ATTENDEE FOREIGN KEY (attendee_id) REFERENCES attendee (id);

ALTER TABLE hacker
    ADD CONSTRAINT FK_HACKER_ON_HACKATHON FOREIGN KEY (hackathon_id) REFERENCES hackathon (id);

ALTER TABLE hacker
    ADD CONSTRAINT FK_HACKER_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (id);

ALTER TABLE judge_assignment
    ADD CONSTRAINT FK_JUDGEASSIGNMENT_ON_JUDGE FOREIGN KEY (judge_id) REFERENCES judge (id);

ALTER TABLE judge_assignment
    ADD CONSTRAINT FK_JUDGEASSIGNMENT_ON_TRACK FOREIGN KEY (track_id) REFERENCES track (id);

ALTER TABLE judge
    ADD CONSTRAINT FK_JUDGE_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE organizer
    ADD CONSTRAINT FK_ORGANIZER_ON_ATTENDEE FOREIGN KEY (attendee_id) REFERENCES attendee (id);

ALTER TABLE organizer
    ADD CONSTRAINT FK_ORGANIZER_ON_HACKATHON FOREIGN KEY (hackathon_id) REFERENCES hackathon (id);

ALTER TABLE project
    ADD CONSTRAINT FK_PROJECT_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (id);

ALTER TABLE resource_recipients
    ADD CONSTRAINT FK_RESOURCE_RECIPIENTS_ON_ATTENDEE FOREIGN KEY (attendee_id) REFERENCES attendee (id);

ALTER TABLE resource_recipients
    ADD CONSTRAINT FK_RESOURCE_RECIPIENTS_ON_RESOURCE FOREIGN KEY (resource_id) REFERENCES resource (id);

ALTER TABLE resource_recipients
    ADD CONSTRAINT FK_RESOURCE_RECIPIENTS_ON_TEAM FOREIGN KEY (team_id) REFERENCES team (id);

ALTER TABLE sponsor
    ADD CONSTRAINT FK_SPONSOR_ON_SPONSOR_ORG FOREIGN KEY (sponsor_org_id) REFERENCES sponsor_org (id);

ALTER TABLE sponsor
    ADD CONSTRAINT FK_SPONSOR_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE submission
    ADD CONSTRAINT FK_SUBMISSION_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE submission
    ADD CONSTRAINT FK_SUBMISSION_ON_TRACK FOREIGN KEY (track_id) REFERENCES track (id);

ALTER TABLE team
    ADD CONSTRAINT FK_TEAM_ON_HACKATHON FOREIGN KEY (hackathon_id) REFERENCES hackathon (id);

ALTER TABLE track
    ADD CONSTRAINT FK_TRACK_ON_SPONSOR FOREIGN KEY (sponsor_id) REFERENCES sponsor (id);