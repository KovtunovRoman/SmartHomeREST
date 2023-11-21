CREATE TABLE IF NOT EXISTS authorization_log (
                       id UUID PRIMARY KEY,
                       card_id UUID NOT NULL REFERENCES authorization_card (id),
                       is_allowed BOOLEAN NOT NULL,
                       date_time TIMESTAMP NOT NULL
);
/*DROP TABLE IF EXISTS authorization_card*/