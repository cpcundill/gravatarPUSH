
# --- !Ups

CREATE TABLE gravatar (
  id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL);

-- social_site (enum of social sites, i.e. twitter, facebook, linkedin)
CREATE TABLE social_site (
  name VARCHAR(255) PRIMARY KEY);

INSERT INTO social_site VALUES ('Twitter');

-- gravatar_social_site (link between a gravatar and social site)
CREATE TABLE gravatar_social_site (
  gravatar_id VARCHAR(255) NOT NULL,
  social_site_name VARCHAR(255) NOT NULL,
  FOREIGN KEY(gravatar_id) REFERENCES gravatar(id),
  FOREIGN KEY(social_site_name) REFERENCES social_site(name));

# --- !Downs

DROP TABLE gravatar;
DROP TABLE social_site;
DROP TABLE gravatar_social_site;