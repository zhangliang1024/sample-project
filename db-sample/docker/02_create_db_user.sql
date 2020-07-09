SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

USE `lzx_ci_sample` ;

SET SQL_MODE = '';
DROP USER IF EXISTS lzx_owner;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'lzx_owner' IDENTIFIED BY '1qaz2WSX';

GRANT ALL ON lzx_ci_sample.* TO 'lzx_owner';
GRANT ALL ON TABLE lzx_ci_sample.* TO 'lzx_owner';
SET SQL_MODE = '';
DROP USER IF EXISTS lzx_app;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'lzx_app' IDENTIFIED BY '1qaz2wsx';

GRANT REFERENCES, INSERT, SELECT, UPDATE, TRIGGER ON TABLE lzx_ci_sample.* TO 'lzx_app';
SET SQL_MODE = '';
DROP USER IF EXISTS lzx_reader;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'lzx_reader' IDENTIFIED BY '1qaz2wsx';

GRANT SELECT ON TABLE lzx_ci_sample.* TO 'lzx_reader';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
