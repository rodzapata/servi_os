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

drop table equipment

CREATE TABLE [dbo].[equipment](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](80) ,
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

CREATE TABLE [dbo].[technician](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
    full_name VARCHAR(80) NOT NULL,
    email VARCHAR(80) UNIQUE NOT NULL,
    phone VARCHAR(80) NOT NULL,
    hire_date DATE
 CONSTRAINT [PK_technician] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[assigned_technician](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
    assigned_date DATE,
	servi_order_id [bigint] NULL,
	technician_id [bigint] NULL
 CONSTRAINT [PK_assigned_technician] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[activity](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	name varchar(250) NOT NULL,
 CONSTRAINT [PK_activity] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[performed_activity](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	servi_order_id [bigint] NULL,
	activity_id [bigint] NULL,
	response_activity varchar(250) NOT NULL
 CONSTRAINT [PK_performed_activity] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[servi_order_spare](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	servi_order_id [bigint] NULL,
	spare_id [bigint] NULL,
	quantity_used numeric(7,2)
 CONSTRAINT [PK_servi_order_spare] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/*========= Facturas ==============*/
CREATE TABLE [dbo].[Producto](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](80),
	[precio] float
 CONSTRAINT [PK_producto] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[detalle_factura](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	producto_id [bigint] NULL,
	factura_id [bigint] NULL,
	cantidad bigint,
	total bigint
 CONSTRAINT [PK_detalle_factura] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[factura](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[cliente] [varchar](80),
    fecha DATE,
	cantidad bigint,
	total bigint
 CONSTRAINT [PK_factura] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/* ==== FIN DE FACTURES */

/*========= ORDER SERVIC ======*/
CREATE TABLE [dbo].[service_order](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
    date DATE,
    order_date DATE,
    scheduled_date DATE,
    completion_date DATE,
	customer_authorization BIT ,
	operational_authorization BIT ,
	coordinator_authorization BIT ,
	note text,
	maintenance_type_id [bigint] NULL,
	customer_id [bigint] NULL,
	equipment_id [bigint] NULL,
 CONSTRAINT [PK_service_order] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[service_order_detail](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
    description varchar(80),
	service_order_id [bigint],
	activity_id [bigint],
	equipment_id [bigint],
	spare_id [bigint] NULL,
	quantity_used [numeric](7, 2) NULL,
 CONSTRAINT [PK_service_order_detail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


/* ========FIN ORDER SERVIC ====*/

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

select * from technician
insert technician(full_name,email,phone,hire_date)
values('2000/01/01','tecnico1 Juan','3100000000','2000/01/01')


insert activity(name) values('Registrar la presión de entrada y salida de agua de agua')
insert activity(name) values('Ajustar acoples. poleas y bandas.')
insert activity(name) values('Inspeccionar los relés. fusibles. bobina. presostatos. breaker. switch. resistencia y termostato.')
insert activity(name) values('Inspeccionar acoples. poleas y correas')
insert activity(name) values('Inspeccionar el evaporador y motor blower.')
insert activity(name) values('Inspeccionar. limpiar o cambiar filtros (según requiera).')
insert activity(name) values('Limpiar el condensador.')
insert activity(name) values('Limpiar y soplar el drenaje de agua condensada.')
insert activity(name) values('Sistema de Control Electrico. verifique y ajuste conexiones eléctricas. Limpiar/corregir sulfatación.')
insert activity(name) values('Verificar el funcionamiento del motor blower.')
insert activity(name) values('Verificar con el cliente estado de funcionamiento del equipo.')
insert activity(name) values('Verificar que el compresor quede con las guardas de proteccion.')
insert activity(name) values('Verificar el filtro secador y acumulador.')
insert activity(name) values('Verificar estado de anclajes del compresor.')
insert activity(name) values('Verificar fijación del compresor y base.')
insert activity(name) values('Verificar fuga de refrigerante.')
insert activity(name) values('Verificar fugas por sello o empaques.')
insert activity(name) values('Verificar funcionamiento correcto del sistema.')
insert activity(name) values('Verificar la carga de refrigerante. si bajo. probar fugas en la unidad.')
insert activity(name) values('Verificar la operación del equipo con el switch de apagado y encendido del A/C.')
insert activity(name) values('Verificar las  presiones  del sistema  en alta y baja. Registrar valores.')
insert activity(name) values('Indicar comentarios del cliente referente al servicio')
insert activity(name) values('Verificar voltaje de operación sea de 12 ó 24 V.')

---pruebas                                                                                                                                                                                     
                                                                                                                                                                                 
insert equipment(name,serial_number,installation_date,
	customer_id, equipment_type_id, brand_id, refrigerant_id)
values('Equipo 1','1005','01/01/2023',3,1,1,1)

insert service_order(date,order_date,customer_id)
values('01/01/2024','01/01/2024',3)

insert service_order_detail(description,service_order_id,activity_id,equipment_id)
values('mantenimiento',1,1,2)



