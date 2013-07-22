INSERT INTO User (
    Id,
    Username, Password,
    DateCreated, CreatedByUserId,
    DateModified, ModifiedByUserId
) VALUES (
    1,
    'anil', 'anil',
    null, 1,
    null, 1
);

INSERT INTO User (
    Id,
    Username, Password,
    DateCreated, CreatedByUserId,
    DateModified, ModifiedByUserId
) VALUES (
    2,
    'user', 'user',
    null, 1,
    null, 1
);

INSERT INTO UserRole (
    UserId, Authority,
    DateCreated, CreatedByUserId,
    DateModified, ModifiedByUserId
) VALUES (
    1, 'ROLE_ADMIN',
    null, 1,
    null, 1
);
INSERT INTO UserRole (
    UserId, Authority,
    DateCreated, CreatedByUserId,
    DateModified, ModifiedByUserId
) VALUES (
    2, 'ROLE_USER',
    null, 1,
    null, 1
);


INSERT INTO Person (
    FirstName, LastName,
    Gender, DOB,
    DateCreated, CreatedByUserId,
    DateModified, ModifiedByUserId
)
VALUES (
    'Anil', 'Bharadia',
    'M', '1989-02-11 00:00:00',
    null, 1,
    null, 1
);

