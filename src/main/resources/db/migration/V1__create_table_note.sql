create table note(
    id UUID PRIMARY KEY,
    header VARCHAR(255) NOT NULL,
    text VARCHAR(255) NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL
);