USE [master]
GO
/****** Object:  Database [QL_KaraokeNice]    Script Date: 12/24/2023 4:13:45 PM ******/
CREATE DATABASE [QL_KaraokeNice]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QL_KaraokeNice', FILENAME = N'E:\DataKaraoke\QL_KaraokeNice.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QL_KaraokeNice_log', FILENAME = N'E:\DataKaraoke\QL_KaraokeNice_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QL_KaraokeNice] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QL_KaraokeNice].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QL_KaraokeNice] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET ARITHABORT OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QL_KaraokeNice] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QL_KaraokeNice] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QL_KaraokeNice] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QL_KaraokeNice] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QL_KaraokeNice] SET  MULTI_USER 
GO
ALTER DATABASE [QL_KaraokeNice] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QL_KaraokeNice] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QL_KaraokeNice] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QL_KaraokeNice] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QL_KaraokeNice] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QL_KaraokeNice] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QL_KaraokeNice] SET QUERY_STORE = ON
GO
ALTER DATABASE [QL_KaraokeNice] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QL_KaraokeNice]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHD] [nvarchar](10) NOT NULL,
	[MaP] [nvarchar](10) NOT NULL,
	[tenP] [nvarchar](50) NULL,
	[ThoiGianSuDungPhong] [time](7) NULL,
	[DonGia] [float] NULL,
	[DonVi] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDatPhong]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDatPhong](
	[MaPDP] [nvarchar](10) NOT NULL,
	[MaP] [nvarchar](10) NOT NULL,
	[ThoiGianSuDungPhong] [time](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPDP] ASC,
	[MaP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSuDungDichVu]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSuDungDichVu](
	[MaPDP] [nvarchar](10) NOT NULL,
	[MaDV] [nvarchar](10) NOT NULL,
	[tenDV] [nvarchar](50) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[DonVi] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPDP] ASC,
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSuDungDichVuHoaDon]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSuDungDichVuHoaDon](
	[MaHD] [nvarchar](10) NOT NULL,
	[MaDV] [nvarchar](10) NOT NULL,
	[tenDV] [nvarchar](50) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[DonVi] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDV] [nvarchar](10) NOT NULL,
	[TenDV] [nvarchar](50) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[DonGia] [float] NOT NULL,
	[MaLDV] [nvarchar](10) NOT NULL,
	[HinhAnh] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [nvarchar](10) NOT NULL,
	[MaNV] [nvarchar](10) NULL,
	[TenKH] [nvarchar](50) NULL,
	[TenNV] [nvarchar](50) NULL,
	[MaKH] [nvarchar](10) NULL,
	[NgayLapHD] [date] NULL,
	[Thoigiantraphong] [time](7) NULL,
	[MaKM] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](10) NOT NULL,
	[HoVaTen] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](100) NOT NULL,
	[SoDienThoai] [nvarchar](20) NOT NULL,
	[CCCD] [nvarchar](20) NOT NULL,
	[NgaySinh] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[MaKM] [nvarchar](10) NOT NULL,
	[TenKM] [nvarchar](50) NOT NULL,
	[DieuKienApDung] [nvarchar](50) NOT NULL,
	[GiaTriKM] [float] NOT NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiDichVu]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiDichVu](
	[MaLDV] [nvarchar](10) NOT NULL,
	[TenLoaiDV] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[MaLP] [nvarchar](10) NOT NULL,
	[TenLoaiPhong] [nvarchar](50) NOT NULL,
	[SoLuongNguoiChuaDuoc] [int] NOT NULL,
	[Gia] [float] NOT NULL,
	[MoTa] [nvarchar](100) NOT NULL,
	[HinhAnh] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](10) NOT NULL,
	[HoVaTen] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[SoDienThoai] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[ChucVu] [nvarchar](50) NOT NULL,
	[TrangThai] [nvarchar](30) NOT NULL,
	[HinhAnh] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[MaPDP] [nvarchar](10) NOT NULL,
	[MaNV] [nvarchar](10) NULL,
	[MaKH] [nvarchar](10) NULL,
	[NgayLapPhieu] [datetime] NULL,
	[NgayNhanPhong] [date] NULL,
	[GioNhanPhong] [time](7) NULL,
	[GioTraPhongDuKien] [time](7) NULL,
	[TinhTrang] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPDP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaP] [nvarchar](10) NOT NULL,
	[TenPhong] [nvarchar](50) NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[MaLP] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaTK] [nvarchar](10) NOT NULL,
	[TenDangNhap] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[MaNV] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaP], [tenP], [ThoiGianSuDungPhong], [DonGia], [DonVi]) VALUES (N'HD001', N'P001', N'Phòng 1', CAST(N'01:00:00' AS Time), 140000, N'Giờ')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaP], [tenP], [ThoiGianSuDungPhong], [DonGia], [DonVi]) VALUES (N'HD002', N'P002', N'Phòng 2', CAST(N'02:00:00' AS Time), 280000, N'Giờ')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaP], [tenP], [ThoiGianSuDungPhong], [DonGia], [DonVi]) VALUES (N'HD003', N'P005', N'Phòng 5', CAST(N'01:45:00' AS Time), 220000, N'Giờ')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaP], [tenP], [ThoiGianSuDungPhong], [DonGia], [DonVi]) VALUES (N'HD004', N'P004', N'Phòng 4', CAST(N'03:05:00' AS Time), 300000, N'Giờ')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaP], [tenP], [ThoiGianSuDungPhong], [DonGia], [DonVi]) VALUES (N'HD005', N'P006', N'Phòng 6', CAST(N'01:00:00' AS Time), 140000, N'Giờ')
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaP], [tenP], [ThoiGianSuDungPhong], [DonGia], [DonVi]) VALUES (N'HD006', N'P001', N'Phòng 1', CAST(N'00:00:00' AS Time), 140000, NULL)
GO
INSERT [dbo].[ChiTietSuDungDichVuHoaDon] ([MaHD], [MaDV], [tenDV], [SoLuong], [DonGia], [DonVi]) VALUES (N'HD001', N'DV001', N'Khăn lạnh', 2, 5500, N'Cái')
INSERT [dbo].[ChiTietSuDungDichVuHoaDon] ([MaHD], [MaDV], [tenDV], [SoLuong], [DonGia], [DonVi]) VALUES (N'HD006', N'DV001', N'Khăn lạnh', 3, 5500, N'cái')
GO
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV001', N'Khăn lạnh', 997, N'cái', 5500, N'LDV003', N'data/images/khanLanh.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV002', N'Thịt trâu khô', 1000, N'Dĩa', 120000, N'LDV002', N'data/images/thitTrauKho.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV003', N'Gà xé lá chanh', 1000, N'Dĩa', 65000, N'LDV002', N'data/images/gaXeLaChanh.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV004', N'Chân gà muối', 1000, N'Dĩa', 102000, N'LDV002', N'data/images/chanGaMuoi.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV005', N'Hạt dẻ cười', 1000, N'Dĩa', 62000, N'LDV002', N'data/images/hatDeCuoi.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV006', N'Hạt Macca', 1000, N'Dĩa', 68000, N'LDV002', N'data/images/hatMacca.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV007', N'Khoai tây chiên', 1000, N'Dĩa', 68000, N'LDV002', N'data/images/khoaiTayChien.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV008', N'Khô bò', 1000, N'Dĩa', 32000, N'LDV002', N'data/images/khoBo.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV009', N'Khô mực', 1000, N'Dĩa', 40000, N'LDV002', N'data/images/KhoMuc.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV010', N'Bánh Snack O''Star', 1000, N'Bịch', 20000, N'LDV002', N'data/images/banhSnackO''Star.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV011', N'Mận', 1000, N'Dĩa', 150000, N'LDV004', N'data/images/Man.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV012', N'Nho Mỹ', 1000, N'Dĩa', 250000, N'LDV004', N'data/images/NhoMy.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV013', N'Cam', 1000, N'Dĩa', 170000, N'LDV004', N'data/images/Cam.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV014', N'Bưởi da xanh', 1000, N'Dĩa', 170000, N'LDV004', N'data/images/BuoiDaXanh.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV015', N'Trái cây thập cẩm', 1000, N'Dĩa', 250000, N'LDV004', N'data/images/diaTraiCay.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV016', N'Bưởi-Mận-Nho', 1000, N'Dĩa', 300000, N'LDV004', N'data/images/Nho-Buoi-Man.png')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV017', N'Nước suối', 1000, N'Chai', 29000, N'LDV001', N'data/images/nuocSuoi.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV018', N'CoCaCoLa', 1000, N'Lon', 33000, N'LDV001', N'data/images/CoCaCoLa.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV019', N'7Up', 1000, N'Lon', 33000, N'LDV001', N'data/images/7up.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV020', N'REDBULL', 1000, N'Lon', 33000, N'LDV001', N'data/images/redBull.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV021', N'Sâm bí đao', 1000, N'Lon', 33000, N'LDV001', N'data/images/samBiDao.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV022', N'Pepsi', 1000, N'Lon', 33000, N'LDV001', N'data/images/pepsi.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV023', N'Sting', 1000, N'Lon', 33000, N'LDV001', N'data/images/Sting.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV024', N'Heineken Nhôm', 1000, N'Chai', 98000, N'LDV005', N'data/images/HeinenkenNhom.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV025', N'Heineken', 1000, N'Lon', 45000, N'LDV005', N'data/images/heineken.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV026', N'Budweiser Nhôm', 1000, N'Chai', 98000, N'LDV005', N'data/images/BudweiserNhom.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV027', N'Bia Tiger', 1000, N'Lon', 45000, N'LDV005', N'data/images/biaTiger.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV028', N'Bia 333', 1000, N'Lon', 45000, N'LDV005', N'data/images/bia333.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV029', N'Blue Label', 1000, N'Chai', 6699000, N'LDV006', N'data/images/Blue Label.jpg')
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [SoLuong], [DonVi], [DonGia], [MaLDV], [HinhAnh]) VALUES (N'DV030', N'MACCALAN 18', 100, N'Chai', 9699000, N'LDV006', N'data/images/MACALLAN18.jpg')
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [TenKH], [TenNV], [MaKH], [NgayLapHD], [Thoigiantraphong], [MaKM]) VALUES (N'HD001', N'NV001', N'Trần Văn Lục', N'Nguyễn Lê Gia Bảo', N'KH001', CAST(N'2022-12-12' AS Date), CAST(N'01:00:00' AS Time), NULL)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [TenKH], [TenNV], [MaKH], [NgayLapHD], [Thoigiantraphong], [MaKM]) VALUES (N'HD002', N'NV001', N'Trần Văn Lục', N'Nguyễn Lê Gia Bảo', N'KH002', CAST(N'2023-12-01' AS Date), CAST(N'02:00:00' AS Time), NULL)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [TenKH], [TenNV], [MaKH], [NgayLapHD], [Thoigiantraphong], [MaKM]) VALUES (N'HD003', N'NV002', N'Nguyễn Bảo', N'Văn Công Thành Đạt', N'KH003', CAST(N'2023-10-10' AS Date), CAST(N'02:00:00' AS Time), NULL)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [TenKH], [TenNV], [MaKH], [NgayLapHD], [Thoigiantraphong], [MaKM]) VALUES (N'HD004', N'NV003 ', N'Nguyễn Bảo', N'Đào Ngọc Anh Khôi', N'KH003', CAST(N'2021-01-01' AS Date), CAST(N'03:00:00' AS Time), NULL)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [TenKH], [TenNV], [MaKH], [NgayLapHD], [Thoigiantraphong], [MaKM]) VALUES (N'HD005', N'NV002', N'Tố Uyên', N'Văn Công Thành Đạt', N'KH005', CAST(N'2023-07-07' AS Date), CAST(N'01:30:00' AS Time), NULL)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [TenKH], [TenNV], [MaKH], [NgayLapHD], [Thoigiantraphong], [MaKM]) VALUES (N'HD006', N'NV001', N'Nguyễn Bảo', N'Nguyễn Lê Gia Bảo', N'KH003', CAST(N'2023-12-15' AS Date), CAST(N'07:24:04' AS Time), NULL)
GO
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH001', N'Trần Văn Lục', 1, N'TP.HCM', N'aaa@gmail.com', N'0367306158', N'111111111111', CAST(N'2003-11-19' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH002', N'Nguyễn Hữu Tuấn', 1, N'TP.HCM', N'aabba@gmail.com', N'0584996869', N'111111111112', CAST(N'2003-11-19' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH003', N'Nguyễn Bảo', 1, N'TP.HCM', N'nguyenlegiabao810@gmail.com', N'0931508027', N'222222222222', CAST(N'2003-11-19' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH004', N'Thành Đạt', 1, N'TP.HCM', N'd@gmail.com', N'1234567891', N'333333333333', CAST(N'2004-12-03' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH005', N'Tố Uyên', 0, N'TP.HCM', N'u@gmail.com', N'1234567892', N'333333333334', CAST(N'2004-12-04' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH006', N'Trịnh Thủy Tiên', 0, N'TP.HCM', N't@gmail.com', N'1234567894', N'333333333335', CAST(N'2004-12-09' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH007', N'Nguyễn Như Hiền', 0, N'TP.HCM', N'h@gmail.com', N'1234567895', N'333333333336', CAST(N'1996-12-14' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH008', N'Trần Thế Hào', 1, N'TP.HCM', N'h@gmail.com', N'1234567896', N'333333333337', CAST(N'2004-12-03' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH009', N'Nguyễn Hồng Anh', 1, N'TP.HCM', N'a@gmail.com', N'1234567897', N'333333333338', CAST(N'2004-12-03' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [HoVaTen], [GioiTinh], [DiaChi], [Email], [SoDienThoai], [CCCD], [NgaySinh]) VALUES (N'KH010', N'Lưu Gia Hân', 0, N'TP.HCM', N'ha@gmail.com', N'1234567898', N'333333333339', CAST(N'1996-12-14' AS Date))
GO
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [DieuKienApDung], [GiaTriKM], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM001', N'Giảm giá 10%', N'Tất cả mọi hóa đơn', 0.1, CAST(N'2023-12-12' AS Date), CAST(N'2023-12-20' AS Date))
GO
INSERT [dbo].[LoaiDichVu] ([MaLDV], [TenLoaiDV]) VALUES (N'LDV001', N'Nước ngọt')
INSERT [dbo].[LoaiDichVu] ([MaLDV], [TenLoaiDV]) VALUES (N'LDV002', N'Đồ khô')
INSERT [dbo].[LoaiDichVu] ([MaLDV], [TenLoaiDV]) VALUES (N'LDV003', N'Khác')
INSERT [dbo].[LoaiDichVu] ([MaLDV], [TenLoaiDV]) VALUES (N'LDV004', N'Trái cây')
INSERT [dbo].[LoaiDichVu] ([MaLDV], [TenLoaiDV]) VALUES (N'LDV005', N'Bia')
INSERT [dbo].[LoaiDichVu] ([MaLDV], [TenLoaiDV]) VALUES (N'LDV006', N'Rượu')
GO
INSERT [dbo].[LoaiPhong] ([MaLP], [TenLoaiPhong], [SoLuongNguoiChuaDuoc], [Gia], [MoTa], [HinhAnh]) VALUES (N'LP001', N'Phòng thường', 5, 140000, N'có máy lạnh, wifi, phòng rộng 9m2', N'data/images/phongThuong.jpg')
INSERT [dbo].[LoaiPhong] ([MaLP], [TenLoaiPhong], [SoLuongNguoiChuaDuoc], [Gia], [MoTa], [HinhAnh]) VALUES (N'LP002', N'Phòng super vip', 20, 300000, N'có máy lạnh, wifi, phòng rộng 100m2', N'data/images/phongSuperVip.jpg')
INSERT [dbo].[LoaiPhong] ([MaLP], [TenLoaiPhong], [SoLuongNguoiChuaDuoc], [Gia], [MoTa], [HinhAnh]) VALUES (N'LP003', N'Phòng vip', 15, 220000, N'có máy lạnh, wifi, phòng rộng 50m2', N'data/images/phongVip.jpg')
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoVaTen], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi], [ChucVu], [TrangThai], [HinhAnh]) VALUES (N'NV001', N'Nguyễn Lê Gia Bảo', CAST(N'2002-10-10' AS Date), 1, N'0931508027', N'226/xx/9,Nguyễn Văn Lượng,P99,Q.Gò Vấp', N'Quản lí', N'Đang làm', N'data/images/GiaBao.png')
INSERT [dbo].[NhanVien] ([MaNV], [HoVaTen], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi], [ChucVu], [TrangThai], [HinhAnh]) VALUES (N'NV002', N'Văn Công Thành Đạt', CAST(N'2001-11-02' AS Date), 1, N'0367306158', N'TP.HCM', N'Quản lí', N'Đang làm', N'data/images/ThanhDat.png')
INSERT [dbo].[NhanVien] ([MaNV], [HoVaTen], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi], [ChucVu], [TrangThai], [HinhAnh]) VALUES (N'NV003', N'Đào Ngọc Anh Khôi', CAST(N'2003-12-10' AS Date), 1, N'0933888999', N'TP.HCM', N'Nhân viên', N'Đang làm', N'data/images/DaoNgocAnhKhoi.jpg')
INSERT [dbo].[NhanVien] ([MaNV], [HoVaTen], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi], [ChucVu], [TrangThai], [HinhAnh]) VALUES (N'NV004', N'Nguyễn Văn A', CAST(N'1992-12-11' AS Date), 1, N'0999111222', N'TP.HCM', N'Nhân viên', N'Đã nghỉ', N'data/images/NhanVienA.jpg')
INSERT [dbo].[NhanVien] ([MaNV], [HoVaTen], [NgaySinh], [GioiTinh], [SoDienThoai], [DiaChi], [ChucVu], [TrangThai], [HinhAnh]) VALUES (N'NV005', N'Nguyễn Văn B', CAST(N'1992-12-04' AS Date), 0, N'0333111333', N'12,Nguyễn Văn Bảo,Q.Gò Vấp', N'Quản lí', N'Đã nghỉ', N'data/images/NhanVienB.jpg')
GO
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P001', N'Phòng 1', N'Phòng trống', N'LP001')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P002', N'Phòng 2', N'Phòng trống', N'LP001')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P003', N'Phòng 3', N'Phòng trống', N'LP001')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P004', N'Phòng 4', N'Phòng đang bảo trì', N'LP001')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P005', N'Phòng 5', N'Phòng trống', N'LP002')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P006', N'Phòng 6', N'Phòng trống', N'LP001')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P007', N'Phòng 7', N'Phòng trống', N'LP001')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P008', N'Phòng 8', N'Phòng trống', N'LP002')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P009', N'Phòng 9', N'Phòng trống', N'LP003')
INSERT [dbo].[Phong] ([MaP], [TenPhong], [TrangThai], [MaLP]) VALUES (N'P010', N'Phòng 10', N'Phòng trống', N'LP003')
GO
INSERT [dbo].[TaiKhoan] ([MaTK], [TenDangNhap], [MatKhau], [MaNV]) VALUES (N'TK001', N'QL0001', N'aA!12345', N'NV001')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenDangNhap], [MatKhau], [MaNV]) VALUES (N'TK002', N'QL0002', N'aA!12345', N'NV002')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenDangNhap], [MatKhau], [MaNV]) VALUES (N'TK003', N'NV0003', N'aA!12345', N'NV003')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaP])
REFERENCES [dbo].[Phong] ([MaP])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatPhong]  WITH CHECK ADD FOREIGN KEY([MaPDP])
REFERENCES [dbo].[PhieuDatPhong] ([MaPDP])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatPhong]  WITH CHECK ADD FOREIGN KEY([MaP])
REFERENCES [dbo].[Phong] ([MaP])
GO
ALTER TABLE [dbo].[ChiTietSuDungDichVu]  WITH CHECK ADD FOREIGN KEY([MaPDP])
REFERENCES [dbo].[PhieuDatPhong] ([MaPDP])
GO
ALTER TABLE [dbo].[ChiTietSuDungDichVu]  WITH CHECK ADD FOREIGN KEY([MaDV])
REFERENCES [dbo].[DichVu] ([MaDV])
GO
ALTER TABLE [dbo].[ChiTietSuDungDichVuHoaDon]  WITH CHECK ADD FOREIGN KEY([MaDV])
REFERENCES [dbo].[DichVu] ([MaDV])
GO
ALTER TABLE [dbo].[ChiTietSuDungDichVuHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[DichVu]  WITH CHECK ADD FOREIGN KEY([MaLDV])
REFERENCES [dbo].[LoaiDichVu] ([MaLDV])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaKM])
REFERENCES [dbo].[KhuyenMai] ([MaKM])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaNV] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaNV]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD FOREIGN KEY([MaLP])
REFERENCES [dbo].[LoaiPhong] ([MaLP])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
/****** Object:  StoredProcedure [dbo].[phatSinhID]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[phatSinhID]
    @NewEmployeeID nvarchar(10) OUTPUT
AS
BEGIN
    DECLARE @MaxEmployeeID nvarchar(10)
    SET @MaxEmployeeID = (SELECT MAX(MaNV) FROM NhanVien)
    IF @MaxEmployeeID IS NULL
    BEGIN
        SET @NewEmployeeID = 'NV001'
    END
    ELSE
    BEGIN
        DECLARE @Number int
        SET @Number = CONVERT(int, RIGHT(@MaxEmployeeID, 3)) + 1
        SET @NewEmployeeID = 'NV' + RIGHT('00' + CONVERT(nvarchar(3), @Number), 3)
    END
END
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDDV]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- phát sinh ID dịch vụ
CREATE PROCEDURE [dbo].[PhatSinhIDDV]
    @NewDVID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxDVID NVARCHAR(10)
    SET @MaxDVID = (SELECT MAX(MaDV) FROM DichVu)
    IF @MaxDVID IS NULL
    BEGIN
        SET @NewDVID = 'DV001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxDVID, 3)) + 1
        SET @NewDVID = 'DV' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDHD]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[PhatSinhIDHD]
    @NewHDID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxHDID NVARCHAR(10)
    SET @MaxHDID = (SELECT MAX(MaHD) FROM HoaDon)
    IF @MaxHDID IS NULL
    BEGIN
        SET @NewHDID = 'HD001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxHDID, 3)) + 1
        SET @NewHDID = 'HD' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDKH]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[PhatSinhIDKH]
    @NewKHID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxKHID NVARCHAR(10)
    SET @MaxKHID = (SELECT MAX(MaKH) FROM KhachHang)
    IF @MaxKHID IS NULL
    BEGIN
        SET @NewKHID = 'KH001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxKHID, 3)) + 1
        SET @NewKHID = 'KH' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDKM]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[PhatSinhIDKM]
    @NewKMID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxKMID NVARCHAR(10)
    SET @MaxKMID = (SELECT MAX(MaKM) FROM KhuyenMai)
    IF @MaxKMID IS NULL
    BEGIN
        SET @NewKMID = 'KM001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxKMID, 3)) + 1
        SET @NewKMID = 'KM' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDLDV]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[PhatSinhIDLDV]
    @NewLDVID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxLDVID NVARCHAR(10)
    SET @MaxLDVID = (SELECT MAX(MaLDV) FROM LoaiDichVu)
    IF @MaxLDVID IS NULL
    BEGIN
        SET @NewLDVID = 'LDV001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxLDVID, 3)) + 1
        SET @NewLDVID = 'LDV' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDLP]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[PhatSinhIDLP]
    @NewLPID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxLPID NVARCHAR(10)
    SET @MaxLPID = (SELECT MAX(MaLP) FROM LoaiPhong)
    IF @MaxLPID IS NULL
    BEGIN
        SET @NewLPID = 'LP001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxLPID, 3)) + 1
        SET @NewLPID = 'LP' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDP]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[PhatSinhIDP]
    @NewPID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxPID NVARCHAR(10)
    SET @MaxPID = (SELECT MAX(MaP) FROM Phong)
    IF @MaxPID IS NULL
    BEGIN
        SET @NewPID = 'P001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxPID, 3)) + 1
        SET @NewPID = 'P' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[PhatSinhIDPDP]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[PhatSinhIDPDP]
    @NewPDPID NVARCHAR(10) OUTPUT
AS
BEGIN
    DECLARE @MaxPDPID NVARCHAR(10)
    SET @MaxPDPID = (SELECT MAX(MaPDP) FROM PhieuDatPhong)
    IF @MaxPDPID IS NULL
    BEGIN
        SET @NewPDPID = 'PDP001'
    END
    ELSE
    BEGIN
        DECLARE @Number INT
        SET @Number = CONVERT(INT, RIGHT(@MaxPDPID, 3)) + 1
        SET @NewPDPID = 'PDP' + RIGHT('000' + CONVERT(NVARCHAR(3), @Number), 3)
    END
END;
GO
/****** Object:  StoredProcedure [dbo].[phatSinhIDTK]    Script Date: 12/24/2023 4:13:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[phatSinhIDTK]
    @NewTKID nvarchar(10) OUTPUT
AS
BEGIN
    DECLARE @MaxTKID nvarchar(10)
    SET @MaxTKID = (SELECT MAX(MaTK) FROM TaiKhoan)
    IF @MaxTKID IS NULL
    BEGIN
        SET @NewTKID = 'TK001'
    END
    ELSE
    BEGIN
        DECLARE @Number int
        SET @Number = CONVERT(int, RIGHT(@MaxTKID, 3)) + 1
        SET @NewTKID = 'TK' + RIGHT('00' + CONVERT(nvarchar(3), @Number), 3)
    END
END
GO
USE [master]
GO
ALTER DATABASE [QL_KaraokeNice] SET  READ_WRITE 
GO
