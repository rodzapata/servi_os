USE [servi_ot]
GO

/****** Object:  Table [dbo].[usuario]    Script Date: 19/07/2024 7:25:40 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[usuario](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[full_name] [varchar](80) NULL,
	[born_date] [datetime] NULL,
	[state] [int] NULL,
	[email] [varchar](80) NULL,
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
	[email] [varchar](80) NULL,
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
	[name] [varchar](80) NULL,

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

    


insert into rol(title) values('administrador')
insert into rol(title) values('asistente')

insert refrigerant(name) values('R-22 (Clorodifluorometano)')
insert refrigerant(name) values('R-410A (Mezcla de Difluorometano y Pentafluoroetano)')
insert refrigerant(name) values('R-32 (Difluorometano)')
insert refrigerant(name) values('R-134a (1,1,1,2-Tetrafluoroetano)')
insert refrigerant(name) values('R-1234yf (2,3,3,3-Tetrafluoropropeno)')
insert refrigerant(name) values('R-404A (Mezcla de HFC-125, HFC-143a y HFC-134a)')

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

select * from brand




