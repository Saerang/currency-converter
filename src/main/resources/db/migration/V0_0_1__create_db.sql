CREATE TABLE `currency` (
  `currency_id` char(3) NOT NULL,
  `scale` int(1) unsigned NOT NULL,
  `exchange_rate` decimal(20,5) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
