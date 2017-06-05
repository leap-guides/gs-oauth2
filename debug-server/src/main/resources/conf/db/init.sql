CREATE TABLE if not exists oauth2_client (
    id varchar(50) NOT NULL,
    secret varchar(500) NULL,
    redirect_uri varchar(1000) NULL,
    redirect_uri_pattern varchar(300) NULL,
    logout_uri varchar(1000) NULL,
    logout_uri_pattern varchar(300) NULL,
    at_expires integer NULL,
    rt_expires integer NULL,
    allow_authz_code boolean NULL,
    allow_refresh_token boolean NULL,
    allow_login_token boolean NULL,
    granted_scope varchar(1000) NULL,
    enabled boolean DEFAULT 1 NULL,
    PRIMARY KEY (id)
)