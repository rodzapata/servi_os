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
	[name] [varchar](80) NULL,

 CONSTRAINT [PK_brand] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].equipment_type(
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](80) NULL,

 CONSTRAINT [PK_equipment_type] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].maintenance_type(
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](80) NULL,

 CONSTRAINT [PK_maintenance_type] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].spare(
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](80) NULL,

 CONSTRAINT [PK_spare] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[equipment](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[customer_id] [bigint] NOT NULL,
	[equipment_type_id] [bigint] NOT NULL,
	[brand_id] [bigint] NOT NULL,
	[refrigerant_id] [bigint] NOT NULL,
	[serial_number] [varchar](80) NOT NULL UNIQUE,
	[installation_date] [datetime] NOT NULL,
	[last_maintenence] [datetime] NOT NULL,
 CONSTRAINT [PK_equipment] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


insert into rol(title) values('administrador')
insert into rol(title) values('asistente')

insert refrigerant(refrigerant_name) values('R-22 (Clorodifluorometano)')
insert refrigerant(refrigerant_name) values('R-410A (Mezcla de Difluorometano y Pentafluoroetano)')
insert refrigerant(refrigerant_name) values('R-32 (Difluorometano)')
insert refrigerant(refrigerant_name) values('R-134a (1,1,1,2-Tetrafluoroetano)')
insert refrigerant(refrigerant_name) values('R-1234yf (2,3,3,3-Tetrafluoropropeno)')
insert refrigerant(refrigerant_name) values('R-404A (Mezcla de HFC-125, HFC-143a y HFC-134a)')

insert brand(name) values('LG')
insert brand(name) values('Samsung')
insert brand(name) values('Daikin')
insert brand(name) values('Panasonic')
insert brand(name) values('Mitsubishi Electric')
insert brand(name) values('York')
insert brand(name) values('Carrier')
insert brand(name) values('Whirlpool')
insert brand(name) values('Haier')
insert brand(name) values('Midea')
insert brand(name) values('Olimpo')

insert equipment_type(name) values('SPLIT')
insert equipment_type(name) values('CHILLER')
insert equipment_type(name) values('VENTANA')
insert equipment_type(name) values('VENTILADOR')
insert equipment_type(name) values('TORRE')
insert equipment_type(name) values('FANCOIL')
insert equipment_type(name) values('NEVERA')
insert equipment_type(name) values('ENFRIADOR')
insert equipment_type(name) values('BOMBA')
insert equipment_type(name) values('LAVADOR')
insert equipment_type(name) values('CUARTO FRIO')
insert equipment_type(name) values('EVAPORADOR')
insert equipment_type(name) values('CONDENSADOR')
insert equipment_type(name) values('PAQUETE')
insert equipment_type(name) values('UMA')
insert equipment_type(name) values('CASETTE')
insert equipment_type(name) values('RECUPERADORA')
insert equipment_type(name) values('PRECISION')
insert equipment_type(name) values('MINISPLIT')
insert equipment_type(name) values('MULTISPLIT')
insert equipment_type(name) values('CENTRAL')
insert equipment_type(name) values('PISO PARED')
insert equipment_type(name) values('PISO TECHO')
insert equipment_type(name) values('CENTRAL DESNUDO')
insert equipment_type(name) values('CAMPANA')
insert equipment_type(name) values('CORTINA DE AIRE')
insert equipment_type(name) values('DISPENSADOR DE AGUA')           

insert maintenance_type(name) values('PREVENTIVO')           
insert maintenance_type(name) values('CORRECTIVO')   

insert spare(name) values('COMPRESOR')
insert spare(name) values('CONDENSADOR')
insert spare(name) values('EVAPORADOR')
insert spare(name) values('FILTRO DE AIRE')
insert spare(name) values('TERMOSTATO')
insert spare(name) values('VENTILADOR (FAN)')
insert spare(name) values('VALVULA DE EXPANSION')
insert spare(name) values('MOTOR DEL VENTILADOR')
insert spare(name) values('REFRIGERANTE')
insert spare(name) values('PLACA DE CONTROL ELECTRONICO')
insert spare(name) values('FUSIBLES Y RELES')
insert spare(name) values('CAPACITOR')
insert spare(name) values('TUBERIAS Y CONECTORES DEL REFRIGERANTE')
insert spare(name) values('BOMBA DE CONDENSADO')
insert spare(name) values('SENSOR DE TEMPERATURA')


select * from brand




