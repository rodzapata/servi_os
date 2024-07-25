USE [servi_ot]
GO

/****** Object:  Table [dbo].[usuario]    Script Date: 19/07/2024 7:25:40 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user_login](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[full_name] [varchar](80) NULL,
	[born_date] [datetime] NULL,
	[state] [int] NULL,
	[email] [varchar](80) NOT NULL UNIQUE,
	[phone] [varchar](80) NULL,
	[avatar] [varchar](80) NULL,
	[password] [varchar](80) NULL,
	[rol_id] [bigint] NULL,
 CONSTRAINT [PK_usuario] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [servi_ot]
GO

/****** Object:  Table [dbo].[rol]    Script Date: 19/07/2024 7:26:51 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[rol](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [varchar](80) NULL,
 CONSTRAINT [PK_rol] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[customer](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[full_name] [varchar](80) NULL,
	[born_date] [datetime] NULL,
	[state] [int] NULL,
	[email] [varchar](80) NOT NULL UNIQUE,
	[phone] [varchar](80) NULL,
	[address] [varchar](80) NULL,
	[city] [varchar](80) NULL,

 CONSTRAINT [PK_customer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[refrigerant](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[refrigerant_name] [varchar](80) NOT NULL UNIQUE,

 CONSTRAINT [PK_refrigerant] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].brand(
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[brand_name] [varchar](80) NULL,

 CONSTRAINT [PK_brand] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].equipment_type(
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[equipment_type_name] [varchar](80) NULL,

 CONSTRAINT [PK_equipment_type] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].maintenance_type(
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[maintenance_type_name] [varchar](80) NULL,

 CONSTRAINT [PK_maintenance_type] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].spare(
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[spare_name] [varchar](80) NULL,

 CONSTRAINT [PK_spare] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[equipment](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[serial_number] [varchar](80) NOT NULL UNIQUE,
	[installation_date] [datetime] NOT NULL,
	[last_maintenance_date] [datetime] NULL,
	[customer_id] [bigint] NULL,
	[equipment_type_id] [bigint] NULL,
	[brand_id] [bigint] NULL,
	[refrigerant_id] [bigint] NULL,
 CONSTRAINT [PK_equipment] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


insert into rol(title) values('ADMINISTRADOR')
insert into rol(title) values('ASISTENTE')

insert refrigerant(refrigerant_name) values('GAS REFRIGERANTE R-22')
insert refrigerant(refrigerant_name) values('GAS REFRIGERANTE R-410A')
insert refrigerant(refrigerant_name) values('GAS REFRIGERANTE R-32')
insert refrigerant(refrigerant_name) values('GAS REFRIGERANTE R-134a')
insert refrigerant(refrigerant_name) values('GAS REFRIGERANTE R-1234yf')
insert refrigerant(refrigerant_name) values('GAS REFRIGERANTE R-404A')

insert brand(brand_name) values('LG')
insert brand(brand_name) values('SAMSUNG')
insert brand(brand_name) values('DAIKIN')
insert brand(brand_name) values('PANASONIC')
insert brand(brand_name) values('MITSUBISHI ELECTRIC')
insert brand(brand_name) values('YORK')
insert brand(brand_name) values('CARRIER')
insert brand(brand_name) values('WHIRLPOOL')
insert brand(brand_name) values('HAIER')
insert brand(brand_name) values('MIIDEA')
insert brand(brand_name) values('OLIMPO')

insert equipment_type(equipment_type_name) values('SPLIT')
insert equipment_type(equipment_type_name) values('CHILLER')
insert equipment_type(equipment_type_name) values('VENTANA')
insert equipment_type(equipment_type_name) values('VENTILADOR')
insert equipment_type(equipment_type_name) values('TORRE')
insert equipment_type(equipment_type_name) values('FANCOIL')
insert equipment_type(equipment_type_name) values('NEVERA')
insert equipment_type(equipment_type_name) values('ENFRIADOR')
insert equipment_type(equipment_type_name) values('BOMBA')
insert equipment_type(equipment_type_name) values('LAVADOR')
insert equipment_type(equipment_type_name) values('CUARTO FRIO')
insert equipment_type(equipment_type_name) values('EVAPORADOR')
insert equipment_type(equipment_type_name) values('CONDENSADOR')
insert equipment_type(equipment_type_name) values('PAQUETE')
insert equipment_type(equipment_type_name) values('UMA')
insert equipment_type(equipment_type_name) values('CASETTE')
insert equipment_type(equipment_type_name) values('RECUPERADORA')
insert equipment_type(equipment_type_name) values('PRECISION')
insert equipment_type(equipment_type_name) values('MINISPLIT')
insert equipment_type(equipment_type_name) values('MULTISPLIT')
insert equipment_type(equipment_type_name) values('CENTRAL')
insert equipment_type(equipment_type_name) values('PISO PARED')
insert equipment_type(equipment_type_name) values('PISO TECHO')
insert equipment_type(equipment_type_name) values('CENTRAL DESNUDO')
insert equipment_type(equipment_type_name) values('CAMPANA')
insert equipment_type(equipment_type_name) values('CORTINA DE AIRE')
insert equipment_type(equipment_type_name) values('DISPENSADOR DE AGUA')           

insert maintenance_type(maintenance_type_name) values('PREVENTIVO')           
insert maintenance_type(maintenance_type_name) values('CORRECTIVO')   

insert spare(spare_name) values('COMPRESOR')
insert spare(spare_name) values('CONDENSADOR')
insert spare(spare_name) values('EVAPORADOR')
insert spare(spare_name) values('FILTRO DE AIRE')
insert spare(spare_name) values('TERMOSTATO')
insert spare(spare_name) values('VENTILADOR (FAN)')
insert spare(spare_name) values('VALVULA DE EXPANSION')
insert spare(spare_name) values('MOTOR DEL VENTILADOR')
insert spare(spare_name) values('REFRIGERANTE')
insert spare(spare_name) values('PLACA DE CONTROL ELECTRONICO')
insert spare(spare_name) values('FUSIBLES Y RELES')
insert spare(spare_name) values('CAPACITOR')
insert spare(spare_name) values('TUBERIAS Y CONECTORES DEL REFRIGERANTE')
insert spare(spare_name) values('BOMBA DE CONDENSADO')
insert spare(spare_name) values('SENSOR DE TEMPERATURA')


insert customer(full_name, born_date, state, email, phone,address, city)
values('Evelin Palacio','1985/02/01', 1, 'evelin@gmail.com','300400500','calle 10', 'Barranquilla')
insert customer(full_name, born_date, state, email, phone,address, city)
values('Tecnoglas','1950/02/01', 1, 'tecnoglas@gmail.com','3104001122','via 40', 'Barranquilla')


select * from brand




