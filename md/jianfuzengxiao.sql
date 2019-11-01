/*
Navicat MySQL Data Transfer

Source Server         : dazong
Source Server Version : 50534
Source Host           : 192.168.124.10:3306
Source Database       : jianfuzengxiao

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2019-11-01 20:39:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `admin_id` int(10) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `satl` varchar(6) NOT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '姓名',
  `gender` int(1) NOT NULL COMMENT '1男2女',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `nation_id` int(4) DEFAULT NULL,
  `nation_name` varchar(16) DEFAULT NULL,
  `telephone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `role_id` int(10) DEFAULT NULL,
  `role_name` varchar(16) DEFAULT NULL,
  `is_wx` int(1) DEFAULT '1' COMMENT '是否关联微信1否2是',
  `wx_openid` varchar(32) DEFAULT NULL,
  `wx_photo` varchar(256) DEFAULT NULL COMMENT '微信头像',
  `wx_time` datetime DEFAULT NULL COMMENT '关联微信时间',
  `wx_password` varchar(32) DEFAULT NULL COMMENT '登录小程序时的密码',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('1', 'admin', 'ab9ccef13f483b0e36f722a3d7657a3e', 'QBa12a', '管理员', '1', '2019-10-29 10:10:01', '1', '汉族', '13000000000', '1', '系统管理员', '2', 'ooU9c5QrAJx9Bsp91szTbsMi1_nQ', '', '2019-11-01 19:13:56', 'ab9ccef13f483b0e36f722a3d7657a3e', '2019-10-29 10:10:22', '2019-11-01 19:13:56', 'A');

-- ----------------------------
-- Table structure for aduit_distribution
-- ----------------------------
DROP TABLE IF EXISTS `aduit_distribution`;
CREATE TABLE `aduit_distribution` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_id` int(10) NOT NULL,
  `houses_id` int(10) NOT NULL,
  `status` int(1) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aduit_distribution
-- ----------------------------
INSERT INTO `aduit_distribution` VALUES ('1', '1', '1', null, '2019-10-31 15:29:56', null, 'A');
INSERT INTO `aduit_distribution` VALUES ('2', '1', '2', null, '2019-10-31 15:42:27', null, 'A');

-- ----------------------------
-- Table structure for area_info
-- ----------------------------
DROP TABLE IF EXISTS `area_info`;
CREATE TABLE `area_info` (
  `area_code` varchar(6) NOT NULL,
  `parent_code` varchar(6) DEFAULT NULL,
  `area_name` varchar(32) DEFAULT NULL,
  `area_level` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`area_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area_info
-- ----------------------------
INSERT INTO `area_info` VALUES ('110000', null, '北京市', '1');
INSERT INTO `area_info` VALUES ('110100', '110000', '北京市', '2');
INSERT INTO `area_info` VALUES ('110101', '110100', '东城区', '3');
INSERT INTO `area_info` VALUES ('110102', '110100', '西城区', '3');
INSERT INTO `area_info` VALUES ('110105', '110100', '朝阳区', '3');
INSERT INTO `area_info` VALUES ('110106', '110100', '丰台区', '3');
INSERT INTO `area_info` VALUES ('110107', '110100', '石景山区', '3');
INSERT INTO `area_info` VALUES ('110108', '110100', '海淀区', '3');
INSERT INTO `area_info` VALUES ('110109', '110100', '门头沟区', '3');
INSERT INTO `area_info` VALUES ('110111', '110100', '房山区', '3');
INSERT INTO `area_info` VALUES ('110112', '110100', '通州区', '3');
INSERT INTO `area_info` VALUES ('110113', '110100', '顺义区', '3');
INSERT INTO `area_info` VALUES ('110114', '110100', '昌平区', '3');
INSERT INTO `area_info` VALUES ('110115', '110100', '大兴区', '3');
INSERT INTO `area_info` VALUES ('110116', '110100', '怀柔区', '3');
INSERT INTO `area_info` VALUES ('110117', '110100', '平谷区', '3');
INSERT INTO `area_info` VALUES ('110118', '110100', '密云区', '3');
INSERT INTO `area_info` VALUES ('110119', '110100', '延庆区', '3');
INSERT INTO `area_info` VALUES ('120000', null, '天津市', '1');
INSERT INTO `area_info` VALUES ('120100', '120000', '天津市', '2');
INSERT INTO `area_info` VALUES ('120101', '120100', '和平区', '3');
INSERT INTO `area_info` VALUES ('120102', '120100', '河东区', '3');
INSERT INTO `area_info` VALUES ('120103', '120100', '河西区', '3');
INSERT INTO `area_info` VALUES ('120104', '120100', '南开区', '3');
INSERT INTO `area_info` VALUES ('120105', '120100', '河北区', '3');
INSERT INTO `area_info` VALUES ('120106', '120100', '红桥区', '3');
INSERT INTO `area_info` VALUES ('120110', '120100', '东丽区', '3');
INSERT INTO `area_info` VALUES ('120111', '120100', '西青区', '3');
INSERT INTO `area_info` VALUES ('120112', '120100', '津南区', '3');
INSERT INTO `area_info` VALUES ('120113', '120100', '北辰区', '3');
INSERT INTO `area_info` VALUES ('120114', '120100', '武清区', '3');
INSERT INTO `area_info` VALUES ('120115', '120100', '宝坻区', '3');
INSERT INTO `area_info` VALUES ('120116', '120100', '滨海新区', '3');
INSERT INTO `area_info` VALUES ('120117', '120100', '宁河区', '3');
INSERT INTO `area_info` VALUES ('120118', '120100', '静海区', '3');
INSERT INTO `area_info` VALUES ('120119', '120100', '蓟州区', '3');
INSERT INTO `area_info` VALUES ('130000', null, '河北省', '1');
INSERT INTO `area_info` VALUES ('130100', '130000', '石家庄市', '2');
INSERT INTO `area_info` VALUES ('130101', '130100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130102', '130100', '长安区', '3');
INSERT INTO `area_info` VALUES ('130104', '130100', '桥西区', '3');
INSERT INTO `area_info` VALUES ('130105', '130100', '新华区', '3');
INSERT INTO `area_info` VALUES ('130107', '130100', '井陉矿区', '3');
INSERT INTO `area_info` VALUES ('130108', '130100', '裕华区', '3');
INSERT INTO `area_info` VALUES ('130109', '130100', '藁城区', '3');
INSERT INTO `area_info` VALUES ('130110', '130100', '鹿泉区', '3');
INSERT INTO `area_info` VALUES ('130111', '130100', '栾城区', '3');
INSERT INTO `area_info` VALUES ('130121', '130100', '井陉县', '3');
INSERT INTO `area_info` VALUES ('130123', '130100', '正定县', '3');
INSERT INTO `area_info` VALUES ('130125', '130100', '行唐县', '3');
INSERT INTO `area_info` VALUES ('130126', '130100', '灵寿县', '3');
INSERT INTO `area_info` VALUES ('130127', '130100', '高邑县', '3');
INSERT INTO `area_info` VALUES ('130128', '130100', '深泽县', '3');
INSERT INTO `area_info` VALUES ('130129', '130100', '赞皇县', '3');
INSERT INTO `area_info` VALUES ('130130', '130100', '无极县', '3');
INSERT INTO `area_info` VALUES ('130131', '130100', '平山县', '3');
INSERT INTO `area_info` VALUES ('130132', '130100', '元氏县', '3');
INSERT INTO `area_info` VALUES ('130133', '130100', '赵县', '3');
INSERT INTO `area_info` VALUES ('130183', '130100', '晋州市', '3');
INSERT INTO `area_info` VALUES ('130184', '130100', '新乐市', '3');
INSERT INTO `area_info` VALUES ('130200', '130000', '唐山市', '2');
INSERT INTO `area_info` VALUES ('130201', '130200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130202', '130200', '路南区', '3');
INSERT INTO `area_info` VALUES ('130203', '130200', '路北区', '3');
INSERT INTO `area_info` VALUES ('130204', '130200', '古冶区', '3');
INSERT INTO `area_info` VALUES ('130205', '130200', '开平区', '3');
INSERT INTO `area_info` VALUES ('130207', '130200', '丰南区', '3');
INSERT INTO `area_info` VALUES ('130208', '130200', '丰润区', '3');
INSERT INTO `area_info` VALUES ('130209', '130200', '曹妃甸区', '3');
INSERT INTO `area_info` VALUES ('130223', '130200', '滦县', '3');
INSERT INTO `area_info` VALUES ('130224', '130200', '滦南县', '3');
INSERT INTO `area_info` VALUES ('130225', '130200', '乐亭县', '3');
INSERT INTO `area_info` VALUES ('130227', '130200', '迁西县', '3');
INSERT INTO `area_info` VALUES ('130229', '130200', '玉田县', '3');
INSERT INTO `area_info` VALUES ('130281', '130200', '遵化市', '3');
INSERT INTO `area_info` VALUES ('130283', '130200', '迁安市', '3');
INSERT INTO `area_info` VALUES ('130300', '130000', '秦皇岛市', '2');
INSERT INTO `area_info` VALUES ('130301', '130300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130302', '130300', '海港区', '3');
INSERT INTO `area_info` VALUES ('130303', '130300', '山海关区', '3');
INSERT INTO `area_info` VALUES ('130304', '130300', '北戴河区', '3');
INSERT INTO `area_info` VALUES ('130306', '130300', '抚宁区', '3');
INSERT INTO `area_info` VALUES ('130321', '130300', '青龙满族自治县', '3');
INSERT INTO `area_info` VALUES ('130322', '130300', '昌黎县', '3');
INSERT INTO `area_info` VALUES ('130324', '130300', '卢龙县', '3');
INSERT INTO `area_info` VALUES ('130400', '130000', '邯郸市', '2');
INSERT INTO `area_info` VALUES ('130401', '130400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130402', '130400', '邯山区', '3');
INSERT INTO `area_info` VALUES ('130403', '130400', '丛台区', '3');
INSERT INTO `area_info` VALUES ('130404', '130400', '复兴区', '3');
INSERT INTO `area_info` VALUES ('130406', '130400', '峰峰矿区', '3');
INSERT INTO `area_info` VALUES ('130421', '130400', '邯郸县', '3');
INSERT INTO `area_info` VALUES ('130423', '130400', '临漳县', '3');
INSERT INTO `area_info` VALUES ('130424', '130400', '成安县', '3');
INSERT INTO `area_info` VALUES ('130425', '130400', '大名县', '3');
INSERT INTO `area_info` VALUES ('130426', '130400', '涉县', '3');
INSERT INTO `area_info` VALUES ('130427', '130400', '磁县', '3');
INSERT INTO `area_info` VALUES ('130428', '130400', '肥乡县', '3');
INSERT INTO `area_info` VALUES ('130429', '130400', '永年县', '3');
INSERT INTO `area_info` VALUES ('130430', '130400', '邱县', '3');
INSERT INTO `area_info` VALUES ('130431', '130400', '鸡泽县', '3');
INSERT INTO `area_info` VALUES ('130432', '130400', '广平县', '3');
INSERT INTO `area_info` VALUES ('130433', '130400', '馆陶县', '3');
INSERT INTO `area_info` VALUES ('130434', '130400', '魏县', '3');
INSERT INTO `area_info` VALUES ('130435', '130400', '曲周县', '3');
INSERT INTO `area_info` VALUES ('130481', '130400', '武安市', '3');
INSERT INTO `area_info` VALUES ('130500', '130000', '邢台市', '2');
INSERT INTO `area_info` VALUES ('130501', '130500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130502', '130500', '桥东区', '3');
INSERT INTO `area_info` VALUES ('130503', '130500', '桥西区', '3');
INSERT INTO `area_info` VALUES ('130521', '130500', '邢台县', '3');
INSERT INTO `area_info` VALUES ('130522', '130500', '临城县', '3');
INSERT INTO `area_info` VALUES ('130523', '130500', '内丘县', '3');
INSERT INTO `area_info` VALUES ('130524', '130500', '柏乡县', '3');
INSERT INTO `area_info` VALUES ('130525', '130500', '隆尧县', '3');
INSERT INTO `area_info` VALUES ('130526', '130500', '任县', '3');
INSERT INTO `area_info` VALUES ('130527', '130500', '南和县', '3');
INSERT INTO `area_info` VALUES ('130528', '130500', '宁晋县', '3');
INSERT INTO `area_info` VALUES ('130529', '130500', '巨鹿县', '3');
INSERT INTO `area_info` VALUES ('130530', '130500', '新河县', '3');
INSERT INTO `area_info` VALUES ('130531', '130500', '广宗县', '3');
INSERT INTO `area_info` VALUES ('130532', '130500', '平乡县', '3');
INSERT INTO `area_info` VALUES ('130533', '130500', '威县', '3');
INSERT INTO `area_info` VALUES ('130534', '130500', '清河县', '3');
INSERT INTO `area_info` VALUES ('130535', '130500', '临西县', '3');
INSERT INTO `area_info` VALUES ('130581', '130500', '南宫市', '3');
INSERT INTO `area_info` VALUES ('130582', '130500', '沙河市', '3');
INSERT INTO `area_info` VALUES ('130600', '130000', '保定市', '2');
INSERT INTO `area_info` VALUES ('130601', '130600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130602', '130600', '竞秀区', '3');
INSERT INTO `area_info` VALUES ('130606', '130600', '莲池区', '3');
INSERT INTO `area_info` VALUES ('130607', '130600', '满城区', '3');
INSERT INTO `area_info` VALUES ('130608', '130600', '清苑区', '3');
INSERT INTO `area_info` VALUES ('130609', '130600', '徐水区', '3');
INSERT INTO `area_info` VALUES ('130623', '130600', '涞水县', '3');
INSERT INTO `area_info` VALUES ('130624', '130600', '阜平县', '3');
INSERT INTO `area_info` VALUES ('130626', '130600', '定兴县', '3');
INSERT INTO `area_info` VALUES ('130627', '130600', '唐县', '3');
INSERT INTO `area_info` VALUES ('130628', '130600', '高阳县', '3');
INSERT INTO `area_info` VALUES ('130629', '130600', '容城县', '3');
INSERT INTO `area_info` VALUES ('130630', '130600', '涞源县', '3');
INSERT INTO `area_info` VALUES ('130631', '130600', '望都县', '3');
INSERT INTO `area_info` VALUES ('130632', '130600', '安新县', '3');
INSERT INTO `area_info` VALUES ('130633', '130600', '易县', '3');
INSERT INTO `area_info` VALUES ('130634', '130600', '曲阳县', '3');
INSERT INTO `area_info` VALUES ('130635', '130600', '蠡县', '3');
INSERT INTO `area_info` VALUES ('130636', '130600', '顺平县', '3');
INSERT INTO `area_info` VALUES ('130637', '130600', '博野县', '3');
INSERT INTO `area_info` VALUES ('130638', '130600', '雄县', '3');
INSERT INTO `area_info` VALUES ('130681', '130600', '涿州市', '3');
INSERT INTO `area_info` VALUES ('130683', '130600', '安国市', '3');
INSERT INTO `area_info` VALUES ('130684', '130600', '高碑店市', '3');
INSERT INTO `area_info` VALUES ('130700', '130000', '张家口市', '2');
INSERT INTO `area_info` VALUES ('130701', '130700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130702', '130700', '桥东区', '3');
INSERT INTO `area_info` VALUES ('130703', '130700', '桥西区', '3');
INSERT INTO `area_info` VALUES ('130705', '130700', '宣化区', '3');
INSERT INTO `area_info` VALUES ('130706', '130700', '下花园区', '3');
INSERT INTO `area_info` VALUES ('130708', '130700', '万全区', '3');
INSERT INTO `area_info` VALUES ('130709', '130700', '崇礼区', '3');
INSERT INTO `area_info` VALUES ('130722', '130700', '张北县', '3');
INSERT INTO `area_info` VALUES ('130723', '130700', '康保县', '3');
INSERT INTO `area_info` VALUES ('130724', '130700', '沽源县', '3');
INSERT INTO `area_info` VALUES ('130725', '130700', '尚义县', '3');
INSERT INTO `area_info` VALUES ('130726', '130700', '蔚县', '3');
INSERT INTO `area_info` VALUES ('130727', '130700', '阳原县', '3');
INSERT INTO `area_info` VALUES ('130728', '130700', '怀安县', '3');
INSERT INTO `area_info` VALUES ('130730', '130700', '怀来县', '3');
INSERT INTO `area_info` VALUES ('130731', '130700', '涿鹿县', '3');
INSERT INTO `area_info` VALUES ('130732', '130700', '赤城县', '3');
INSERT INTO `area_info` VALUES ('130800', '130000', '承德市', '2');
INSERT INTO `area_info` VALUES ('130801', '130800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130802', '130800', '双桥区', '3');
INSERT INTO `area_info` VALUES ('130803', '130800', '双滦区', '3');
INSERT INTO `area_info` VALUES ('130804', '130800', '鹰手营子矿区', '3');
INSERT INTO `area_info` VALUES ('130821', '130800', '承德县', '3');
INSERT INTO `area_info` VALUES ('130822', '130800', '兴隆县', '3');
INSERT INTO `area_info` VALUES ('130823', '130800', '平泉县', '3');
INSERT INTO `area_info` VALUES ('130824', '130800', '滦平县', '3');
INSERT INTO `area_info` VALUES ('130825', '130800', '隆化县', '3');
INSERT INTO `area_info` VALUES ('130826', '130800', '丰宁满族自治县', '3');
INSERT INTO `area_info` VALUES ('130827', '130800', '宽城满族自治县', '3');
INSERT INTO `area_info` VALUES ('130828', '130800', '围场满族蒙古族自治县', '3');
INSERT INTO `area_info` VALUES ('130900', '130000', '沧州市', '2');
INSERT INTO `area_info` VALUES ('130901', '130900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('130902', '130900', '新华区', '3');
INSERT INTO `area_info` VALUES ('130903', '130900', '运河区', '3');
INSERT INTO `area_info` VALUES ('130921', '130900', '沧县', '3');
INSERT INTO `area_info` VALUES ('130922', '130900', '青县', '3');
INSERT INTO `area_info` VALUES ('130923', '130900', '东光县', '3');
INSERT INTO `area_info` VALUES ('130924', '130900', '海兴县', '3');
INSERT INTO `area_info` VALUES ('130925', '130900', '盐山县', '3');
INSERT INTO `area_info` VALUES ('130926', '130900', '肃宁县', '3');
INSERT INTO `area_info` VALUES ('130927', '130900', '南皮县', '3');
INSERT INTO `area_info` VALUES ('130928', '130900', '吴桥县', '3');
INSERT INTO `area_info` VALUES ('130929', '130900', '献县', '3');
INSERT INTO `area_info` VALUES ('130930', '130900', '孟村回族自治县', '3');
INSERT INTO `area_info` VALUES ('130981', '130900', '泊头市', '3');
INSERT INTO `area_info` VALUES ('130982', '130900', '任丘市', '3');
INSERT INTO `area_info` VALUES ('130983', '130900', '黄骅市', '3');
INSERT INTO `area_info` VALUES ('130984', '130900', '河间市', '3');
INSERT INTO `area_info` VALUES ('131000', '130000', '廊坊市', '2');
INSERT INTO `area_info` VALUES ('131001', '131000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('131002', '131000', '安次区', '3');
INSERT INTO `area_info` VALUES ('131003', '131000', '广阳区', '3');
INSERT INTO `area_info` VALUES ('131022', '131000', '固安县', '3');
INSERT INTO `area_info` VALUES ('131023', '131000', '永清县', '3');
INSERT INTO `area_info` VALUES ('131024', '131000', '香河县', '3');
INSERT INTO `area_info` VALUES ('131025', '131000', '大城县', '3');
INSERT INTO `area_info` VALUES ('131026', '131000', '文安县', '3');
INSERT INTO `area_info` VALUES ('131028', '131000', '大厂回族自治县', '3');
INSERT INTO `area_info` VALUES ('131081', '131000', '霸州市', '3');
INSERT INTO `area_info` VALUES ('131082', '131000', '三河市', '3');
INSERT INTO `area_info` VALUES ('131100', '130000', '衡水市', '2');
INSERT INTO `area_info` VALUES ('131101', '131100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('131102', '131100', '桃城区', '3');
INSERT INTO `area_info` VALUES ('131103', '131100', '冀州区', '3');
INSERT INTO `area_info` VALUES ('131121', '131100', '枣强县', '3');
INSERT INTO `area_info` VALUES ('131122', '131100', '武邑县', '3');
INSERT INTO `area_info` VALUES ('131123', '131100', '武强县', '3');
INSERT INTO `area_info` VALUES ('131124', '131100', '饶阳县', '3');
INSERT INTO `area_info` VALUES ('131125', '131100', '安平县', '3');
INSERT INTO `area_info` VALUES ('131126', '131100', '故城县', '3');
INSERT INTO `area_info` VALUES ('131127', '131100', '景县', '3');
INSERT INTO `area_info` VALUES ('131128', '131100', '阜城县', '3');
INSERT INTO `area_info` VALUES ('131182', '131100', '深州市', '3');
INSERT INTO `area_info` VALUES ('139000', '130000', '省直辖县级行政区划', '2');
INSERT INTO `area_info` VALUES ('139001', '139000', '定州市', '3');
INSERT INTO `area_info` VALUES ('139002', '139000', '辛集市', '3');
INSERT INTO `area_info` VALUES ('140000', null, '山西省', '1');
INSERT INTO `area_info` VALUES ('140100', '140000', '太原市', '2');
INSERT INTO `area_info` VALUES ('140101', '140100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140105', '140100', '小店区', '3');
INSERT INTO `area_info` VALUES ('140106', '140100', '迎泽区', '3');
INSERT INTO `area_info` VALUES ('140107', '140100', '杏花岭区', '3');
INSERT INTO `area_info` VALUES ('140108', '140100', '尖草坪区', '3');
INSERT INTO `area_info` VALUES ('140109', '140100', '万柏林区', '3');
INSERT INTO `area_info` VALUES ('140110', '140100', '晋源区', '3');
INSERT INTO `area_info` VALUES ('140121', '140100', '清徐县', '3');
INSERT INTO `area_info` VALUES ('140122', '140100', '阳曲县', '3');
INSERT INTO `area_info` VALUES ('140123', '140100', '娄烦县', '3');
INSERT INTO `area_info` VALUES ('140181', '140100', '古交市', '3');
INSERT INTO `area_info` VALUES ('140200', '140000', '大同市', '2');
INSERT INTO `area_info` VALUES ('140201', '140200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140202', '140200', '城区', '3');
INSERT INTO `area_info` VALUES ('140203', '140200', '矿区', '3');
INSERT INTO `area_info` VALUES ('140211', '140200', '南郊区', '3');
INSERT INTO `area_info` VALUES ('140212', '140200', '新荣区', '3');
INSERT INTO `area_info` VALUES ('140221', '140200', '阳高县', '3');
INSERT INTO `area_info` VALUES ('140222', '140200', '天镇县', '3');
INSERT INTO `area_info` VALUES ('140223', '140200', '广灵县', '3');
INSERT INTO `area_info` VALUES ('140224', '140200', '灵丘县', '3');
INSERT INTO `area_info` VALUES ('140225', '140200', '浑源县', '3');
INSERT INTO `area_info` VALUES ('140226', '140200', '左云县', '3');
INSERT INTO `area_info` VALUES ('140227', '140200', '大同县', '3');
INSERT INTO `area_info` VALUES ('140300', '140000', '阳泉市', '2');
INSERT INTO `area_info` VALUES ('140301', '140300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140302', '140300', '城区', '3');
INSERT INTO `area_info` VALUES ('140303', '140300', '矿区', '3');
INSERT INTO `area_info` VALUES ('140311', '140300', '郊区', '3');
INSERT INTO `area_info` VALUES ('140321', '140300', '平定县', '3');
INSERT INTO `area_info` VALUES ('140322', '140300', '盂县', '3');
INSERT INTO `area_info` VALUES ('140400', '140000', '长治市', '2');
INSERT INTO `area_info` VALUES ('140401', '140400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140402', '140400', '城区', '3');
INSERT INTO `area_info` VALUES ('140411', '140400', '郊区', '3');
INSERT INTO `area_info` VALUES ('140421', '140400', '长治县', '3');
INSERT INTO `area_info` VALUES ('140423', '140400', '襄垣县', '3');
INSERT INTO `area_info` VALUES ('140424', '140400', '屯留县', '3');
INSERT INTO `area_info` VALUES ('140425', '140400', '平顺县', '3');
INSERT INTO `area_info` VALUES ('140426', '140400', '黎城县', '3');
INSERT INTO `area_info` VALUES ('140427', '140400', '壶关县', '3');
INSERT INTO `area_info` VALUES ('140428', '140400', '长子县', '3');
INSERT INTO `area_info` VALUES ('140429', '140400', '武乡县', '3');
INSERT INTO `area_info` VALUES ('140430', '140400', '沁县', '3');
INSERT INTO `area_info` VALUES ('140431', '140400', '沁源县', '3');
INSERT INTO `area_info` VALUES ('140481', '140400', '潞城市', '3');
INSERT INTO `area_info` VALUES ('140500', '140000', '晋城市', '2');
INSERT INTO `area_info` VALUES ('140501', '140500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140502', '140500', '城区', '3');
INSERT INTO `area_info` VALUES ('140521', '140500', '沁水县', '3');
INSERT INTO `area_info` VALUES ('140522', '140500', '阳城县', '3');
INSERT INTO `area_info` VALUES ('140524', '140500', '陵川县', '3');
INSERT INTO `area_info` VALUES ('140525', '140500', '泽州县', '3');
INSERT INTO `area_info` VALUES ('140581', '140500', '高平市', '3');
INSERT INTO `area_info` VALUES ('140600', '140000', '朔州市', '2');
INSERT INTO `area_info` VALUES ('140601', '140600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140602', '140600', '朔城区', '3');
INSERT INTO `area_info` VALUES ('140603', '140600', '平鲁区', '3');
INSERT INTO `area_info` VALUES ('140621', '140600', '山阴县', '3');
INSERT INTO `area_info` VALUES ('140622', '140600', '应县', '3');
INSERT INTO `area_info` VALUES ('140623', '140600', '右玉县', '3');
INSERT INTO `area_info` VALUES ('140624', '140600', '怀仁县', '3');
INSERT INTO `area_info` VALUES ('140700', '140000', '晋中市', '2');
INSERT INTO `area_info` VALUES ('140701', '140700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140702', '140700', '榆次区', '3');
INSERT INTO `area_info` VALUES ('140721', '140700', '榆社县', '3');
INSERT INTO `area_info` VALUES ('140722', '140700', '左权县', '3');
INSERT INTO `area_info` VALUES ('140723', '140700', '和顺县', '3');
INSERT INTO `area_info` VALUES ('140724', '140700', '昔阳县', '3');
INSERT INTO `area_info` VALUES ('140725', '140700', '寿阳县', '3');
INSERT INTO `area_info` VALUES ('140726', '140700', '太谷县', '3');
INSERT INTO `area_info` VALUES ('140727', '140700', '祁县', '3');
INSERT INTO `area_info` VALUES ('140728', '140700', '平遥县', '3');
INSERT INTO `area_info` VALUES ('140729', '140700', '灵石县', '3');
INSERT INTO `area_info` VALUES ('140781', '140700', '介休市', '3');
INSERT INTO `area_info` VALUES ('140800', '140000', '运城市', '2');
INSERT INTO `area_info` VALUES ('140801', '140800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140802', '140800', '盐湖区', '3');
INSERT INTO `area_info` VALUES ('140821', '140800', '临猗县', '3');
INSERT INTO `area_info` VALUES ('140822', '140800', '万荣县', '3');
INSERT INTO `area_info` VALUES ('140823', '140800', '闻喜县', '3');
INSERT INTO `area_info` VALUES ('140824', '140800', '稷山县', '3');
INSERT INTO `area_info` VALUES ('140825', '140800', '新绛县', '3');
INSERT INTO `area_info` VALUES ('140826', '140800', '绛县', '3');
INSERT INTO `area_info` VALUES ('140827', '140800', '垣曲县', '3');
INSERT INTO `area_info` VALUES ('140828', '140800', '夏县', '3');
INSERT INTO `area_info` VALUES ('140829', '140800', '平陆县', '3');
INSERT INTO `area_info` VALUES ('140830', '140800', '芮城县', '3');
INSERT INTO `area_info` VALUES ('140881', '140800', '永济市', '3');
INSERT INTO `area_info` VALUES ('140882', '140800', '河津市', '3');
INSERT INTO `area_info` VALUES ('140900', '140000', '忻州市', '2');
INSERT INTO `area_info` VALUES ('140901', '140900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('140902', '140900', '忻府区', '3');
INSERT INTO `area_info` VALUES ('140921', '140900', '定襄县', '3');
INSERT INTO `area_info` VALUES ('140922', '140900', '五台县', '3');
INSERT INTO `area_info` VALUES ('140923', '140900', '代县', '3');
INSERT INTO `area_info` VALUES ('140924', '140900', '繁峙县', '3');
INSERT INTO `area_info` VALUES ('140925', '140900', '宁武县', '3');
INSERT INTO `area_info` VALUES ('140926', '140900', '静乐县', '3');
INSERT INTO `area_info` VALUES ('140927', '140900', '神池县', '3');
INSERT INTO `area_info` VALUES ('140928', '140900', '五寨县', '3');
INSERT INTO `area_info` VALUES ('140929', '140900', '岢岚县', '3');
INSERT INTO `area_info` VALUES ('140930', '140900', '河曲县', '3');
INSERT INTO `area_info` VALUES ('140931', '140900', '保德县', '3');
INSERT INTO `area_info` VALUES ('140932', '140900', '偏关县', '3');
INSERT INTO `area_info` VALUES ('140981', '140900', '原平市', '3');
INSERT INTO `area_info` VALUES ('141000', '140000', '临汾市', '2');
INSERT INTO `area_info` VALUES ('141001', '141000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('141002', '141000', '尧都区', '3');
INSERT INTO `area_info` VALUES ('141021', '141000', '曲沃县', '3');
INSERT INTO `area_info` VALUES ('141022', '141000', '翼城县', '3');
INSERT INTO `area_info` VALUES ('141023', '141000', '襄汾县', '3');
INSERT INTO `area_info` VALUES ('141024', '141000', '洪洞县', '3');
INSERT INTO `area_info` VALUES ('141025', '141000', '古县', '3');
INSERT INTO `area_info` VALUES ('141026', '141000', '安泽县', '3');
INSERT INTO `area_info` VALUES ('141027', '141000', '浮山县', '3');
INSERT INTO `area_info` VALUES ('141028', '141000', '吉县', '3');
INSERT INTO `area_info` VALUES ('141029', '141000', '乡宁县', '3');
INSERT INTO `area_info` VALUES ('141030', '141000', '大宁县', '3');
INSERT INTO `area_info` VALUES ('141031', '141000', '隰县', '3');
INSERT INTO `area_info` VALUES ('141032', '141000', '永和县', '3');
INSERT INTO `area_info` VALUES ('141033', '141000', '蒲县', '3');
INSERT INTO `area_info` VALUES ('141034', '141000', '汾西县', '3');
INSERT INTO `area_info` VALUES ('141081', '141000', '侯马市', '3');
INSERT INTO `area_info` VALUES ('141082', '141000', '霍州市', '3');
INSERT INTO `area_info` VALUES ('141100', '140000', '吕梁市', '2');
INSERT INTO `area_info` VALUES ('141101', '141100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('141102', '141100', '离石区', '3');
INSERT INTO `area_info` VALUES ('141121', '141100', '文水县', '3');
INSERT INTO `area_info` VALUES ('141122', '141100', '交城县', '3');
INSERT INTO `area_info` VALUES ('141123', '141100', '兴县', '3');
INSERT INTO `area_info` VALUES ('141124', '141100', '临县', '3');
INSERT INTO `area_info` VALUES ('141125', '141100', '柳林县', '3');
INSERT INTO `area_info` VALUES ('141126', '141100', '石楼县', '3');
INSERT INTO `area_info` VALUES ('141127', '141100', '岚县', '3');
INSERT INTO `area_info` VALUES ('141128', '141100', '方山县', '3');
INSERT INTO `area_info` VALUES ('141129', '141100', '中阳县', '3');
INSERT INTO `area_info` VALUES ('141130', '141100', '交口县', '3');
INSERT INTO `area_info` VALUES ('141181', '141100', '孝义市', '3');
INSERT INTO `area_info` VALUES ('141182', '141100', '汾阳市', '3');
INSERT INTO `area_info` VALUES ('150000', null, '内蒙古', '1');
INSERT INTO `area_info` VALUES ('150100', '150000', '呼和浩特市', '2');
INSERT INTO `area_info` VALUES ('150101', '150100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150102', '150100', '新城区', '3');
INSERT INTO `area_info` VALUES ('150103', '150100', '回民区', '3');
INSERT INTO `area_info` VALUES ('150104', '150100', '玉泉区', '3');
INSERT INTO `area_info` VALUES ('150105', '150100', '赛罕区', '3');
INSERT INTO `area_info` VALUES ('150121', '150100', '土默特左旗', '3');
INSERT INTO `area_info` VALUES ('150122', '150100', '托克托县', '3');
INSERT INTO `area_info` VALUES ('150123', '150100', '和林格尔县', '3');
INSERT INTO `area_info` VALUES ('150124', '150100', '清水河县', '3');
INSERT INTO `area_info` VALUES ('150125', '150100', '武川县', '3');
INSERT INTO `area_info` VALUES ('150200', '150000', '包头市', '2');
INSERT INTO `area_info` VALUES ('150201', '150200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150202', '150200', '东河区', '3');
INSERT INTO `area_info` VALUES ('150203', '150200', '昆都仑区', '3');
INSERT INTO `area_info` VALUES ('150204', '150200', '青山区', '3');
INSERT INTO `area_info` VALUES ('150205', '150200', '石拐区', '3');
INSERT INTO `area_info` VALUES ('150206', '150200', '白云鄂博矿区', '3');
INSERT INTO `area_info` VALUES ('150207', '150200', '九原区', '3');
INSERT INTO `area_info` VALUES ('150221', '150200', '土默特右旗', '3');
INSERT INTO `area_info` VALUES ('150222', '150200', '固阳县', '3');
INSERT INTO `area_info` VALUES ('150223', '150200', '达尔罕茂明安联合旗', '3');
INSERT INTO `area_info` VALUES ('150300', '150000', '乌海市', '2');
INSERT INTO `area_info` VALUES ('150301', '150300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150302', '150300', '海勃湾区', '3');
INSERT INTO `area_info` VALUES ('150303', '150300', '海南区', '3');
INSERT INTO `area_info` VALUES ('150304', '150300', '乌达区', '3');
INSERT INTO `area_info` VALUES ('150400', '150000', '赤峰市', '2');
INSERT INTO `area_info` VALUES ('150401', '150400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150402', '150400', '红山区', '3');
INSERT INTO `area_info` VALUES ('150403', '150400', '元宝山区', '3');
INSERT INTO `area_info` VALUES ('150404', '150400', '松山区', '3');
INSERT INTO `area_info` VALUES ('150421', '150400', '阿鲁科尔沁旗', '3');
INSERT INTO `area_info` VALUES ('150422', '150400', '巴林左旗', '3');
INSERT INTO `area_info` VALUES ('150423', '150400', '巴林右旗', '3');
INSERT INTO `area_info` VALUES ('150424', '150400', '林西县', '3');
INSERT INTO `area_info` VALUES ('150425', '150400', '克什克腾旗', '3');
INSERT INTO `area_info` VALUES ('150426', '150400', '翁牛特旗', '3');
INSERT INTO `area_info` VALUES ('150428', '150400', '喀喇沁旗', '3');
INSERT INTO `area_info` VALUES ('150429', '150400', '宁城县', '3');
INSERT INTO `area_info` VALUES ('150430', '150400', '敖汉旗', '3');
INSERT INTO `area_info` VALUES ('150500', '150000', '通辽市', '2');
INSERT INTO `area_info` VALUES ('150501', '150500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150502', '150500', '科尔沁区', '3');
INSERT INTO `area_info` VALUES ('150521', '150500', '科尔沁左翼中旗', '3');
INSERT INTO `area_info` VALUES ('150522', '150500', '科尔沁左翼后旗', '3');
INSERT INTO `area_info` VALUES ('150523', '150500', '开鲁县', '3');
INSERT INTO `area_info` VALUES ('150524', '150500', '库伦旗', '3');
INSERT INTO `area_info` VALUES ('150525', '150500', '奈曼旗', '3');
INSERT INTO `area_info` VALUES ('150526', '150500', '扎鲁特旗', '3');
INSERT INTO `area_info` VALUES ('150581', '150500', '霍林郭勒市', '3');
INSERT INTO `area_info` VALUES ('150600', '150000', '鄂尔多斯市', '2');
INSERT INTO `area_info` VALUES ('150601', '150600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150602', '150600', '东胜区', '3');
INSERT INTO `area_info` VALUES ('150603', '150600', '康巴什区', '3');
INSERT INTO `area_info` VALUES ('150621', '150600', '达拉特旗', '3');
INSERT INTO `area_info` VALUES ('150622', '150600', '准格尔旗', '3');
INSERT INTO `area_info` VALUES ('150623', '150600', '鄂托克前旗', '3');
INSERT INTO `area_info` VALUES ('150624', '150600', '鄂托克旗', '3');
INSERT INTO `area_info` VALUES ('150625', '150600', '杭锦旗', '3');
INSERT INTO `area_info` VALUES ('150626', '150600', '乌审旗', '3');
INSERT INTO `area_info` VALUES ('150627', '150600', '伊金霍洛旗', '3');
INSERT INTO `area_info` VALUES ('150700', '150000', '呼伦贝尔市', '2');
INSERT INTO `area_info` VALUES ('150701', '150700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150702', '150700', '海拉尔区', '3');
INSERT INTO `area_info` VALUES ('150703', '150700', '扎赉诺尔区', '3');
INSERT INTO `area_info` VALUES ('150721', '150700', '阿荣旗', '3');
INSERT INTO `area_info` VALUES ('150722', '150700', '莫力达瓦达斡尔族自治旗', '3');
INSERT INTO `area_info` VALUES ('150723', '150700', '鄂伦春自治旗', '3');
INSERT INTO `area_info` VALUES ('150724', '150700', '鄂温克族自治旗', '3');
INSERT INTO `area_info` VALUES ('150725', '150700', '陈巴尔虎旗', '3');
INSERT INTO `area_info` VALUES ('150726', '150700', '新巴尔虎左旗', '3');
INSERT INTO `area_info` VALUES ('150727', '150700', '新巴尔虎右旗', '3');
INSERT INTO `area_info` VALUES ('150781', '150700', '满洲里市', '3');
INSERT INTO `area_info` VALUES ('150782', '150700', '牙克石市', '3');
INSERT INTO `area_info` VALUES ('150783', '150700', '扎兰屯市', '3');
INSERT INTO `area_info` VALUES ('150784', '150700', '额尔古纳市', '3');
INSERT INTO `area_info` VALUES ('150785', '150700', '根河市', '3');
INSERT INTO `area_info` VALUES ('150800', '150000', '巴彦淖尔市', '2');
INSERT INTO `area_info` VALUES ('150801', '150800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150802', '150800', '临河区', '3');
INSERT INTO `area_info` VALUES ('150821', '150800', '五原县', '3');
INSERT INTO `area_info` VALUES ('150822', '150800', '磴口县', '3');
INSERT INTO `area_info` VALUES ('150823', '150800', '乌拉特前旗', '3');
INSERT INTO `area_info` VALUES ('150824', '150800', '乌拉特中旗', '3');
INSERT INTO `area_info` VALUES ('150825', '150800', '乌拉特后旗', '3');
INSERT INTO `area_info` VALUES ('150826', '150800', '杭锦后旗', '3');
INSERT INTO `area_info` VALUES ('150900', '150000', '乌兰察布市', '2');
INSERT INTO `area_info` VALUES ('150901', '150900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('150902', '150900', '集宁区', '3');
INSERT INTO `area_info` VALUES ('150921', '150900', '卓资县', '3');
INSERT INTO `area_info` VALUES ('150922', '150900', '化德县', '3');
INSERT INTO `area_info` VALUES ('150923', '150900', '商都县', '3');
INSERT INTO `area_info` VALUES ('150924', '150900', '兴和县', '3');
INSERT INTO `area_info` VALUES ('150925', '150900', '凉城县', '3');
INSERT INTO `area_info` VALUES ('150926', '150900', '察哈尔右翼前旗', '3');
INSERT INTO `area_info` VALUES ('150927', '150900', '察哈尔右翼中旗', '3');
INSERT INTO `area_info` VALUES ('150928', '150900', '察哈尔右翼后旗', '3');
INSERT INTO `area_info` VALUES ('150929', '150900', '四子王旗', '3');
INSERT INTO `area_info` VALUES ('150981', '150900', '丰镇市', '3');
INSERT INTO `area_info` VALUES ('152200', '150000', '兴安盟', '2');
INSERT INTO `area_info` VALUES ('152201', '152200', '乌兰浩特市', '3');
INSERT INTO `area_info` VALUES ('152202', '152200', '阿尔山市', '3');
INSERT INTO `area_info` VALUES ('152221', '152200', '科尔沁右翼前旗', '3');
INSERT INTO `area_info` VALUES ('152222', '152200', '科尔沁右翼中旗', '3');
INSERT INTO `area_info` VALUES ('152223', '152200', '扎赉特旗', '3');
INSERT INTO `area_info` VALUES ('152224', '152200', '突泉县', '3');
INSERT INTO `area_info` VALUES ('152500', '150000', '锡林郭勒盟', '2');
INSERT INTO `area_info` VALUES ('152501', '152500', '二连浩特市', '3');
INSERT INTO `area_info` VALUES ('152502', '152500', '锡林浩特市', '3');
INSERT INTO `area_info` VALUES ('152522', '152500', '阿巴嘎旗', '3');
INSERT INTO `area_info` VALUES ('152523', '152500', '苏尼特左旗', '3');
INSERT INTO `area_info` VALUES ('152524', '152500', '苏尼特右旗', '3');
INSERT INTO `area_info` VALUES ('152525', '152500', '东乌珠穆沁旗', '3');
INSERT INTO `area_info` VALUES ('152526', '152500', '西乌珠穆沁旗', '3');
INSERT INTO `area_info` VALUES ('152527', '152500', '太仆寺旗', '3');
INSERT INTO `area_info` VALUES ('152528', '152500', '镶黄旗', '3');
INSERT INTO `area_info` VALUES ('152529', '152500', '正镶白旗', '3');
INSERT INTO `area_info` VALUES ('152530', '152500', '正蓝旗', '3');
INSERT INTO `area_info` VALUES ('152531', '152500', '多伦县', '3');
INSERT INTO `area_info` VALUES ('152900', '150000', '阿拉善盟', '2');
INSERT INTO `area_info` VALUES ('152921', '152900', '阿拉善左旗', '3');
INSERT INTO `area_info` VALUES ('152922', '152900', '阿拉善右旗', '3');
INSERT INTO `area_info` VALUES ('152923', '152900', '额济纳旗', '3');
INSERT INTO `area_info` VALUES ('210000', null, '辽宁省', '1');
INSERT INTO `area_info` VALUES ('210100', '210000', '沈阳市', '2');
INSERT INTO `area_info` VALUES ('210101', '210100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210102', '210100', '和平区', '3');
INSERT INTO `area_info` VALUES ('210103', '210100', '沈河区', '3');
INSERT INTO `area_info` VALUES ('210104', '210100', '大东区', '3');
INSERT INTO `area_info` VALUES ('210105', '210100', '皇姑区', '3');
INSERT INTO `area_info` VALUES ('210106', '210100', '铁西区', '3');
INSERT INTO `area_info` VALUES ('210111', '210100', '苏家屯区', '3');
INSERT INTO `area_info` VALUES ('210112', '210100', '浑南区', '3');
INSERT INTO `area_info` VALUES ('210113', '210100', '沈北新区', '3');
INSERT INTO `area_info` VALUES ('210114', '210100', '于洪区', '3');
INSERT INTO `area_info` VALUES ('210115', '210100', '辽中区', '3');
INSERT INTO `area_info` VALUES ('210123', '210100', '康平县', '3');
INSERT INTO `area_info` VALUES ('210124', '210100', '法库县', '3');
INSERT INTO `area_info` VALUES ('210181', '210100', '新民市', '3');
INSERT INTO `area_info` VALUES ('210200', '210000', '大连市', '2');
INSERT INTO `area_info` VALUES ('210201', '210200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210202', '210200', '中山区', '3');
INSERT INTO `area_info` VALUES ('210203', '210200', '西岗区', '3');
INSERT INTO `area_info` VALUES ('210204', '210200', '沙河口区', '3');
INSERT INTO `area_info` VALUES ('210211', '210200', '甘井子区', '3');
INSERT INTO `area_info` VALUES ('210212', '210200', '旅顺口区', '3');
INSERT INTO `area_info` VALUES ('210213', '210200', '金州区', '3');
INSERT INTO `area_info` VALUES ('210214', '210200', '普兰店区', '3');
INSERT INTO `area_info` VALUES ('210224', '210200', '长海县', '3');
INSERT INTO `area_info` VALUES ('210281', '210200', '瓦房店市', '3');
INSERT INTO `area_info` VALUES ('210283', '210200', '庄河市', '3');
INSERT INTO `area_info` VALUES ('210300', '210000', '鞍山市', '2');
INSERT INTO `area_info` VALUES ('210301', '210300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210302', '210300', '铁东区', '3');
INSERT INTO `area_info` VALUES ('210303', '210300', '铁西区', '3');
INSERT INTO `area_info` VALUES ('210304', '210300', '立山区', '3');
INSERT INTO `area_info` VALUES ('210311', '210300', '千山区', '3');
INSERT INTO `area_info` VALUES ('210321', '210300', '台安县', '3');
INSERT INTO `area_info` VALUES ('210323', '210300', '岫岩满族自治县', '3');
INSERT INTO `area_info` VALUES ('210381', '210300', '海城市', '3');
INSERT INTO `area_info` VALUES ('210400', '210000', '抚顺市', '2');
INSERT INTO `area_info` VALUES ('210401', '210400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210402', '210400', '新抚区', '3');
INSERT INTO `area_info` VALUES ('210403', '210400', '东洲区', '3');
INSERT INTO `area_info` VALUES ('210404', '210400', '望花区', '3');
INSERT INTO `area_info` VALUES ('210411', '210400', '顺城区', '3');
INSERT INTO `area_info` VALUES ('210421', '210400', '抚顺县', '3');
INSERT INTO `area_info` VALUES ('210422', '210400', '新宾满族自治县', '3');
INSERT INTO `area_info` VALUES ('210423', '210400', '清原满族自治', '3');
INSERT INTO `area_info` VALUES ('210500', '210000', '本溪市', '2');
INSERT INTO `area_info` VALUES ('210501', '210500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210502', '210500', '平山区', '3');
INSERT INTO `area_info` VALUES ('210503', '210500', '溪湖区', '3');
INSERT INTO `area_info` VALUES ('210504', '210500', '明山区', '3');
INSERT INTO `area_info` VALUES ('210505', '210500', '南芬区', '3');
INSERT INTO `area_info` VALUES ('210521', '210500', '本溪满族自治县', '3');
INSERT INTO `area_info` VALUES ('210522', '210500', '桓仁满族自治县', '3');
INSERT INTO `area_info` VALUES ('210600', '210000', '丹东市', '2');
INSERT INTO `area_info` VALUES ('210601', '210600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210602', '210600', '元宝区', '3');
INSERT INTO `area_info` VALUES ('210603', '210600', '振兴区', '3');
INSERT INTO `area_info` VALUES ('210604', '210600', '振安区', '3');
INSERT INTO `area_info` VALUES ('210624', '210600', '宽甸满族自治县', '3');
INSERT INTO `area_info` VALUES ('210681', '210600', '东港市', '3');
INSERT INTO `area_info` VALUES ('210682', '210600', '凤城市', '3');
INSERT INTO `area_info` VALUES ('210700', '210000', '锦州市', '2');
INSERT INTO `area_info` VALUES ('210701', '210700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210702', '210700', '古塔区', '3');
INSERT INTO `area_info` VALUES ('210703', '210700', '凌河区', '3');
INSERT INTO `area_info` VALUES ('210711', '210700', '太和区', '3');
INSERT INTO `area_info` VALUES ('210726', '210700', '黑山县', '3');
INSERT INTO `area_info` VALUES ('210727', '210700', '义县', '3');
INSERT INTO `area_info` VALUES ('210781', '210700', '凌海市', '3');
INSERT INTO `area_info` VALUES ('210782', '210700', '北镇市', '3');
INSERT INTO `area_info` VALUES ('210800', '210000', '营口市', '2');
INSERT INTO `area_info` VALUES ('210801', '210800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210802', '210800', '站前区', '3');
INSERT INTO `area_info` VALUES ('210803', '210800', '西市区', '3');
INSERT INTO `area_info` VALUES ('210804', '210800', '鲅鱼圈区', '3');
INSERT INTO `area_info` VALUES ('210811', '210800', '老边区', '3');
INSERT INTO `area_info` VALUES ('210881', '210800', '盖州市', '3');
INSERT INTO `area_info` VALUES ('210882', '210800', '大石桥市', '3');
INSERT INTO `area_info` VALUES ('210900', '210000', '阜新市', '2');
INSERT INTO `area_info` VALUES ('210901', '210900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('210902', '210900', '海州区', '3');
INSERT INTO `area_info` VALUES ('210903', '210900', '新邱区', '3');
INSERT INTO `area_info` VALUES ('210904', '210900', '太平区', '3');
INSERT INTO `area_info` VALUES ('210905', '210900', '清河门区', '3');
INSERT INTO `area_info` VALUES ('210911', '210900', '细河区', '3');
INSERT INTO `area_info` VALUES ('210921', '210900', '阜新蒙古族自治县', '3');
INSERT INTO `area_info` VALUES ('210922', '210900', '彰武县', '3');
INSERT INTO `area_info` VALUES ('211000', '210000', '辽阳市', '2');
INSERT INTO `area_info` VALUES ('211001', '211000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('211002', '211000', '白塔区', '3');
INSERT INTO `area_info` VALUES ('211003', '211000', '文圣区', '3');
INSERT INTO `area_info` VALUES ('211004', '211000', '宏伟区', '3');
INSERT INTO `area_info` VALUES ('211005', '211000', '弓长岭区', '3');
INSERT INTO `area_info` VALUES ('211011', '211000', '太子河区', '3');
INSERT INTO `area_info` VALUES ('211021', '211000', '辽阳县', '3');
INSERT INTO `area_info` VALUES ('211081', '211000', '灯塔市', '3');
INSERT INTO `area_info` VALUES ('211100', '210000', '盘锦市', '2');
INSERT INTO `area_info` VALUES ('211101', '211100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('211102', '211100', '双台子区', '3');
INSERT INTO `area_info` VALUES ('211103', '211100', '兴隆台区', '3');
INSERT INTO `area_info` VALUES ('211104', '211100', '大洼区', '3');
INSERT INTO `area_info` VALUES ('211122', '211100', '盘山县', '3');
INSERT INTO `area_info` VALUES ('211200', '210000', '铁岭市', '2');
INSERT INTO `area_info` VALUES ('211201', '211200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('211202', '211200', '银州区', '3');
INSERT INTO `area_info` VALUES ('211204', '211200', '清河区', '3');
INSERT INTO `area_info` VALUES ('211221', '211200', '铁岭县', '3');
INSERT INTO `area_info` VALUES ('211223', '211200', '西丰县', '3');
INSERT INTO `area_info` VALUES ('211224', '211200', '昌图县', '3');
INSERT INTO `area_info` VALUES ('211281', '211200', '调兵山市', '3');
INSERT INTO `area_info` VALUES ('211282', '211200', '开原市', '3');
INSERT INTO `area_info` VALUES ('211300', '210000', '朝阳市', '2');
INSERT INTO `area_info` VALUES ('211301', '211300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('211302', '211300', '双塔区', '3');
INSERT INTO `area_info` VALUES ('211303', '211300', '龙城区', '3');
INSERT INTO `area_info` VALUES ('211321', '211300', '朝阳县', '3');
INSERT INTO `area_info` VALUES ('211322', '211300', '建平县', '3');
INSERT INTO `area_info` VALUES ('211324', '211300', '喀喇沁左翼蒙古族自治县', '3');
INSERT INTO `area_info` VALUES ('211381', '211300', '北票市', '3');
INSERT INTO `area_info` VALUES ('211382', '211300', '凌源市', '3');
INSERT INTO `area_info` VALUES ('211400', '210000', '葫芦岛市', '2');
INSERT INTO `area_info` VALUES ('211401', '211400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('211402', '211400', '连山区', '3');
INSERT INTO `area_info` VALUES ('211403', '211400', '龙港区', '3');
INSERT INTO `area_info` VALUES ('211404', '211400', '南票区', '3');
INSERT INTO `area_info` VALUES ('211421', '211400', '绥中县', '3');
INSERT INTO `area_info` VALUES ('211422', '211400', '建昌县', '3');
INSERT INTO `area_info` VALUES ('211481', '211400', '兴城市', '3');
INSERT INTO `area_info` VALUES ('220000', null, '吉林省', '1');
INSERT INTO `area_info` VALUES ('220100', '220000', '长春市', '2');
INSERT INTO `area_info` VALUES ('220101', '220100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220102', '220100', '南关区', '3');
INSERT INTO `area_info` VALUES ('220103', '220100', '宽城区', '3');
INSERT INTO `area_info` VALUES ('220104', '220100', '朝阳区', '3');
INSERT INTO `area_info` VALUES ('220105', '220100', '二道区', '3');
INSERT INTO `area_info` VALUES ('220106', '220100', '绿园区', '3');
INSERT INTO `area_info` VALUES ('220112', '220100', '双阳区', '3');
INSERT INTO `area_info` VALUES ('220113', '220100', '九台区', '3');
INSERT INTO `area_info` VALUES ('220122', '220100', '农安县', '3');
INSERT INTO `area_info` VALUES ('220182', '220100', '榆树市', '3');
INSERT INTO `area_info` VALUES ('220183', '220100', '德惠市', '3');
INSERT INTO `area_info` VALUES ('220200', '220000', '吉林市', '2');
INSERT INTO `area_info` VALUES ('220201', '220200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220202', '220200', '昌邑区', '3');
INSERT INTO `area_info` VALUES ('220203', '220200', '龙潭区', '3');
INSERT INTO `area_info` VALUES ('220204', '220200', '船营区', '3');
INSERT INTO `area_info` VALUES ('220211', '220200', '丰满区', '3');
INSERT INTO `area_info` VALUES ('220221', '220200', '永吉县', '3');
INSERT INTO `area_info` VALUES ('220281', '220200', '蛟河市', '3');
INSERT INTO `area_info` VALUES ('220282', '220200', '桦甸市', '3');
INSERT INTO `area_info` VALUES ('220283', '220200', '舒兰市', '3');
INSERT INTO `area_info` VALUES ('220284', '220200', '磐石市', '3');
INSERT INTO `area_info` VALUES ('220300', '220000', '四平市', '2');
INSERT INTO `area_info` VALUES ('220301', '220300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220302', '220300', '铁西区', '3');
INSERT INTO `area_info` VALUES ('220303', '220300', '铁东区', '3');
INSERT INTO `area_info` VALUES ('220322', '220300', '梨树县', '3');
INSERT INTO `area_info` VALUES ('220323', '220300', '伊通满族自治县', '3');
INSERT INTO `area_info` VALUES ('220381', '220300', '公主岭市', '3');
INSERT INTO `area_info` VALUES ('220382', '220300', '双辽市', '3');
INSERT INTO `area_info` VALUES ('220400', '220000', '辽源市', '2');
INSERT INTO `area_info` VALUES ('220401', '220400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220402', '220400', '龙山区', '3');
INSERT INTO `area_info` VALUES ('220403', '220400', '西安区', '3');
INSERT INTO `area_info` VALUES ('220421', '220400', '东丰县', '3');
INSERT INTO `area_info` VALUES ('220422', '220400', '东辽县', '3');
INSERT INTO `area_info` VALUES ('220500', '220000', '通化市', '2');
INSERT INTO `area_info` VALUES ('220501', '220500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220502', '220500', '东昌区', '3');
INSERT INTO `area_info` VALUES ('220503', '220500', '二道江区', '3');
INSERT INTO `area_info` VALUES ('220521', '220500', '通化县', '3');
INSERT INTO `area_info` VALUES ('220523', '220500', '辉南县', '3');
INSERT INTO `area_info` VALUES ('220524', '220500', '柳河县', '3');
INSERT INTO `area_info` VALUES ('220581', '220500', '梅河口市', '3');
INSERT INTO `area_info` VALUES ('220582', '220500', '集安市', '3');
INSERT INTO `area_info` VALUES ('220600', '220000', '白山市', '2');
INSERT INTO `area_info` VALUES ('220601', '220600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220602', '220600', '浑江区', '3');
INSERT INTO `area_info` VALUES ('220605', '220600', '江源区', '3');
INSERT INTO `area_info` VALUES ('220621', '220600', '抚松县', '3');
INSERT INTO `area_info` VALUES ('220622', '220600', '靖宇县', '3');
INSERT INTO `area_info` VALUES ('220623', '220600', '长白朝鲜族自治县', '3');
INSERT INTO `area_info` VALUES ('220681', '220600', '临江市', '3');
INSERT INTO `area_info` VALUES ('220700', '220000', '松原市', '2');
INSERT INTO `area_info` VALUES ('220701', '220700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220702', '220700', '宁江区', '3');
INSERT INTO `area_info` VALUES ('220721', '220700', '前郭尔罗斯蒙古族自治县', '3');
INSERT INTO `area_info` VALUES ('220722', '220700', '长岭县', '3');
INSERT INTO `area_info` VALUES ('220723', '220700', '乾安县', '3');
INSERT INTO `area_info` VALUES ('220781', '220700', '扶余市', '3');
INSERT INTO `area_info` VALUES ('220800', '220000', '白城市', '2');
INSERT INTO `area_info` VALUES ('220801', '220800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('220802', '220800', '洮北区', '3');
INSERT INTO `area_info` VALUES ('220821', '220800', '镇赉县', '3');
INSERT INTO `area_info` VALUES ('220822', '220800', '通榆县', '3');
INSERT INTO `area_info` VALUES ('220881', '220800', '洮南市', '3');
INSERT INTO `area_info` VALUES ('220882', '220800', '大安市', '3');
INSERT INTO `area_info` VALUES ('222400', '220000', '延边朝鲜族自治州', '2');
INSERT INTO `area_info` VALUES ('222401', '222400', '延吉市', '3');
INSERT INTO `area_info` VALUES ('222402', '222400', '图们市', '3');
INSERT INTO `area_info` VALUES ('222403', '222400', '敦化市', '3');
INSERT INTO `area_info` VALUES ('222404', '222400', '珲春市', '3');
INSERT INTO `area_info` VALUES ('222405', '222400', '龙井市', '3');
INSERT INTO `area_info` VALUES ('222406', '222400', '和龙市', '3');
INSERT INTO `area_info` VALUES ('222424', '222400', '汪清县', '3');
INSERT INTO `area_info` VALUES ('222426', '222400', '安图县', '3');
INSERT INTO `area_info` VALUES ('230000', null, '黑龙江省', '1');
INSERT INTO `area_info` VALUES ('230100', '230000', '哈尔滨市', '2');
INSERT INTO `area_info` VALUES ('230101', '230100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230102', '230100', '道里区', '3');
INSERT INTO `area_info` VALUES ('230103', '230100', '南岗区', '3');
INSERT INTO `area_info` VALUES ('230104', '230100', '道外区', '3');
INSERT INTO `area_info` VALUES ('230108', '230100', '平房区', '3');
INSERT INTO `area_info` VALUES ('230109', '230100', '松北区', '3');
INSERT INTO `area_info` VALUES ('230110', '230100', '香坊区', '3');
INSERT INTO `area_info` VALUES ('230111', '230100', '呼兰区', '3');
INSERT INTO `area_info` VALUES ('230112', '230100', '阿城区', '3');
INSERT INTO `area_info` VALUES ('230113', '230100', '双城区', '3');
INSERT INTO `area_info` VALUES ('230123', '230100', '依兰县', '3');
INSERT INTO `area_info` VALUES ('230124', '230100', '方正县', '3');
INSERT INTO `area_info` VALUES ('230125', '230100', '宾县', '3');
INSERT INTO `area_info` VALUES ('230126', '230100', '巴彦县', '3');
INSERT INTO `area_info` VALUES ('230127', '230100', '木兰县', '3');
INSERT INTO `area_info` VALUES ('230128', '230100', '通河县', '3');
INSERT INTO `area_info` VALUES ('230129', '230100', '延寿县', '3');
INSERT INTO `area_info` VALUES ('230183', '230100', '尚志市', '3');
INSERT INTO `area_info` VALUES ('230184', '230100', '五常市', '3');
INSERT INTO `area_info` VALUES ('230200', '230000', '齐齐哈尔市', '2');
INSERT INTO `area_info` VALUES ('230201', '230200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230202', '230200', '龙沙区', '3');
INSERT INTO `area_info` VALUES ('230203', '230200', '建华区', '3');
INSERT INTO `area_info` VALUES ('230204', '230200', '铁锋区', '3');
INSERT INTO `area_info` VALUES ('230205', '230200', '昂昂溪区', '3');
INSERT INTO `area_info` VALUES ('230206', '230200', '富拉尔基区', '3');
INSERT INTO `area_info` VALUES ('230207', '230200', '碾子山区', '3');
INSERT INTO `area_info` VALUES ('230208', '230200', '梅里斯达斡尔族区', '3');
INSERT INTO `area_info` VALUES ('230221', '230200', '龙江县', '3');
INSERT INTO `area_info` VALUES ('230223', '230200', '依安县', '3');
INSERT INTO `area_info` VALUES ('230224', '230200', '泰来县', '3');
INSERT INTO `area_info` VALUES ('230225', '230200', '甘南县', '3');
INSERT INTO `area_info` VALUES ('230227', '230200', '富裕县', '3');
INSERT INTO `area_info` VALUES ('230229', '230200', '克山县', '3');
INSERT INTO `area_info` VALUES ('230230', '230200', '克东县', '3');
INSERT INTO `area_info` VALUES ('230231', '230200', '拜泉县', '3');
INSERT INTO `area_info` VALUES ('230281', '230200', '讷河市', '3');
INSERT INTO `area_info` VALUES ('230300', '230000', '鸡西市', '2');
INSERT INTO `area_info` VALUES ('230301', '230300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230302', '230300', '鸡冠区', '3');
INSERT INTO `area_info` VALUES ('230303', '230300', '恒山区', '3');
INSERT INTO `area_info` VALUES ('230304', '230300', '滴道区', '3');
INSERT INTO `area_info` VALUES ('230305', '230300', '梨树区', '3');
INSERT INTO `area_info` VALUES ('230306', '230300', '城子河区', '3');
INSERT INTO `area_info` VALUES ('230307', '230300', '麻山区', '3');
INSERT INTO `area_info` VALUES ('230321', '230300', '鸡东县', '3');
INSERT INTO `area_info` VALUES ('230381', '230300', '虎林市', '3');
INSERT INTO `area_info` VALUES ('230382', '230300', '密山市', '3');
INSERT INTO `area_info` VALUES ('230400', '230000', '鹤岗市', '2');
INSERT INTO `area_info` VALUES ('230401', '230400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230402', '230400', '向阳区', '3');
INSERT INTO `area_info` VALUES ('230403', '230400', '工农区', '3');
INSERT INTO `area_info` VALUES ('230404', '230400', '南山区', '3');
INSERT INTO `area_info` VALUES ('230405', '230400', '兴安区', '3');
INSERT INTO `area_info` VALUES ('230406', '230400', '东山区', '3');
INSERT INTO `area_info` VALUES ('230407', '230400', '兴山区', '3');
INSERT INTO `area_info` VALUES ('230421', '230400', '萝北县', '3');
INSERT INTO `area_info` VALUES ('230422', '230400', '绥滨县', '3');
INSERT INTO `area_info` VALUES ('230500', '230000', '双鸭山市', '2');
INSERT INTO `area_info` VALUES ('230501', '230500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230502', '230500', '尖山区', '3');
INSERT INTO `area_info` VALUES ('230503', '230500', '岭东区', '3');
INSERT INTO `area_info` VALUES ('230505', '230500', '四方台区', '3');
INSERT INTO `area_info` VALUES ('230506', '230500', '宝山区', '3');
INSERT INTO `area_info` VALUES ('230521', '230500', '集贤县', '3');
INSERT INTO `area_info` VALUES ('230522', '230500', '友谊县', '3');
INSERT INTO `area_info` VALUES ('230523', '230500', '宝清县', '3');
INSERT INTO `area_info` VALUES ('230524', '230500', '饶河县', '3');
INSERT INTO `area_info` VALUES ('230600', '230000', '大庆市', '2');
INSERT INTO `area_info` VALUES ('230601', '230600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230602', '230600', '萨尔图区', '3');
INSERT INTO `area_info` VALUES ('230603', '230600', '龙凤区', '3');
INSERT INTO `area_info` VALUES ('230604', '230600', '让胡路区', '3');
INSERT INTO `area_info` VALUES ('230605', '230600', '红岗区', '3');
INSERT INTO `area_info` VALUES ('230606', '230600', '大同区', '3');
INSERT INTO `area_info` VALUES ('230621', '230600', '肇州县', '3');
INSERT INTO `area_info` VALUES ('230622', '230600', '肇源县', '3');
INSERT INTO `area_info` VALUES ('230623', '230600', '林甸县', '3');
INSERT INTO `area_info` VALUES ('230624', '230600', '杜尔伯特蒙古族自治县', '3');
INSERT INTO `area_info` VALUES ('230700', '230000', '伊春市', '2');
INSERT INTO `area_info` VALUES ('230701', '230700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230702', '230700', '伊春区', '3');
INSERT INTO `area_info` VALUES ('230703', '230700', '南岔区', '3');
INSERT INTO `area_info` VALUES ('230704', '230700', '友好区', '3');
INSERT INTO `area_info` VALUES ('230705', '230700', '西林区', '3');
INSERT INTO `area_info` VALUES ('230706', '230700', '翠峦区', '3');
INSERT INTO `area_info` VALUES ('230707', '230700', '新青区', '3');
INSERT INTO `area_info` VALUES ('230708', '230700', '美溪区', '3');
INSERT INTO `area_info` VALUES ('230709', '230700', '金山屯区', '3');
INSERT INTO `area_info` VALUES ('230710', '230700', '五营区', '3');
INSERT INTO `area_info` VALUES ('230711', '230700', '乌马河区', '3');
INSERT INTO `area_info` VALUES ('230712', '230700', '汤旺河区', '3');
INSERT INTO `area_info` VALUES ('230713', '230700', '带岭区', '3');
INSERT INTO `area_info` VALUES ('230714', '230700', '乌伊岭区', '3');
INSERT INTO `area_info` VALUES ('230715', '230700', '红星区', '3');
INSERT INTO `area_info` VALUES ('230716', '230700', '上甘岭区', '3');
INSERT INTO `area_info` VALUES ('230722', '230700', '嘉荫县', '3');
INSERT INTO `area_info` VALUES ('230781', '230700', '铁力市', '3');
INSERT INTO `area_info` VALUES ('230800', '230000', '佳木斯市', '2');
INSERT INTO `area_info` VALUES ('230801', '230800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230803', '230800', '向阳区', '3');
INSERT INTO `area_info` VALUES ('230804', '230800', '前进区', '3');
INSERT INTO `area_info` VALUES ('230805', '230800', '东风区', '3');
INSERT INTO `area_info` VALUES ('230811', '230800', '郊区', '3');
INSERT INTO `area_info` VALUES ('230822', '230800', '桦南县', '3');
INSERT INTO `area_info` VALUES ('230826', '230800', '桦川县', '3');
INSERT INTO `area_info` VALUES ('230828', '230800', '汤原县', '3');
INSERT INTO `area_info` VALUES ('230881', '230800', '同江市', '3');
INSERT INTO `area_info` VALUES ('230882', '230800', '富锦市', '3');
INSERT INTO `area_info` VALUES ('230883', '230800', '抚远市', '3');
INSERT INTO `area_info` VALUES ('230900', '230000', '七台河市', '2');
INSERT INTO `area_info` VALUES ('230901', '230900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('230902', '230900', '新兴区', '3');
INSERT INTO `area_info` VALUES ('230903', '230900', '桃山区', '3');
INSERT INTO `area_info` VALUES ('230904', '230900', '茄子河区', '3');
INSERT INTO `area_info` VALUES ('230921', '230900', '勃利县', '3');
INSERT INTO `area_info` VALUES ('231000', '230000', '牡丹江市', '2');
INSERT INTO `area_info` VALUES ('231001', '231000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('231002', '231000', '东安区', '3');
INSERT INTO `area_info` VALUES ('231003', '231000', '阳明区', '3');
INSERT INTO `area_info` VALUES ('231004', '231000', '爱民区', '3');
INSERT INTO `area_info` VALUES ('231005', '231000', '西安区', '3');
INSERT INTO `area_info` VALUES ('231025', '231000', '林口县', '3');
INSERT INTO `area_info` VALUES ('231081', '231000', '绥芬河市', '3');
INSERT INTO `area_info` VALUES ('231083', '231000', '海林市', '3');
INSERT INTO `area_info` VALUES ('231084', '231000', '宁安市', '3');
INSERT INTO `area_info` VALUES ('231085', '231000', '穆棱市', '3');
INSERT INTO `area_info` VALUES ('231086', '231000', '东宁市', '3');
INSERT INTO `area_info` VALUES ('231100', '230000', '黑河市', '2');
INSERT INTO `area_info` VALUES ('231101', '231100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('231102', '231100', '爱辉区', '3');
INSERT INTO `area_info` VALUES ('231121', '231100', '嫩江县', '3');
INSERT INTO `area_info` VALUES ('231123', '231100', '逊克县', '3');
INSERT INTO `area_info` VALUES ('231124', '231100', '孙吴县', '3');
INSERT INTO `area_info` VALUES ('231181', '231100', '北安市', '3');
INSERT INTO `area_info` VALUES ('231182', '231100', '五大连池市', '3');
INSERT INTO `area_info` VALUES ('231200', '230000', '绥化市', '2');
INSERT INTO `area_info` VALUES ('231201', '231200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('231202', '231200', '北林区', '3');
INSERT INTO `area_info` VALUES ('231221', '231200', '望奎县', '3');
INSERT INTO `area_info` VALUES ('231222', '231200', '兰西县', '3');
INSERT INTO `area_info` VALUES ('231223', '231200', '青冈县', '3');
INSERT INTO `area_info` VALUES ('231224', '231200', '庆安县', '3');
INSERT INTO `area_info` VALUES ('231225', '231200', '明水县', '3');
INSERT INTO `area_info` VALUES ('231226', '231200', '绥棱县', '3');
INSERT INTO `area_info` VALUES ('231281', '231200', '安达市', '3');
INSERT INTO `area_info` VALUES ('231282', '231200', '肇东市', '3');
INSERT INTO `area_info` VALUES ('231283', '231200', '海伦市', '3');
INSERT INTO `area_info` VALUES ('232700', '230000', '大兴安岭地区', '2');
INSERT INTO `area_info` VALUES ('232721', '232700', '呼玛县', '3');
INSERT INTO `area_info` VALUES ('232722', '232700', '塔河县', '3');
INSERT INTO `area_info` VALUES ('232723', '232700', '漠河县', '3');
INSERT INTO `area_info` VALUES ('310000', null, '上海市', '1');
INSERT INTO `area_info` VALUES ('310100', '310000', '上海市', '2');
INSERT INTO `area_info` VALUES ('310101', '310100', '黄浦区', '3');
INSERT INTO `area_info` VALUES ('310104', '310100', '徐汇区', '3');
INSERT INTO `area_info` VALUES ('310105', '310100', '长宁区', '3');
INSERT INTO `area_info` VALUES ('310106', '310100', '静安区', '3');
INSERT INTO `area_info` VALUES ('310107', '310100', '普陀区', '3');
INSERT INTO `area_info` VALUES ('310109', '310100', '虹口区', '3');
INSERT INTO `area_info` VALUES ('310110', '310100', '杨浦区', '3');
INSERT INTO `area_info` VALUES ('310112', '310100', '闵行区', '3');
INSERT INTO `area_info` VALUES ('310113', '310100', '宝山区', '3');
INSERT INTO `area_info` VALUES ('310114', '310100', '嘉定区', '3');
INSERT INTO `area_info` VALUES ('310115', '310100', '浦东新区', '3');
INSERT INTO `area_info` VALUES ('310116', '310100', '金山区', '3');
INSERT INTO `area_info` VALUES ('310117', '310100', '松江区', '3');
INSERT INTO `area_info` VALUES ('310118', '310100', '青浦区', '3');
INSERT INTO `area_info` VALUES ('310120', '310100', '奉贤区', '3');
INSERT INTO `area_info` VALUES ('310151', '310100', '崇明区', '3');
INSERT INTO `area_info` VALUES ('320000', null, '江苏省', '1');
INSERT INTO `area_info` VALUES ('320100', '320000', '南京市', '2');
INSERT INTO `area_info` VALUES ('320101', '320100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320102', '320100', '玄武区', '3');
INSERT INTO `area_info` VALUES ('320104', '320100', '秦淮区', '3');
INSERT INTO `area_info` VALUES ('320105', '320100', '建邺区', '3');
INSERT INTO `area_info` VALUES ('320106', '320100', '鼓楼区', '3');
INSERT INTO `area_info` VALUES ('320111', '320100', '浦口区', '3');
INSERT INTO `area_info` VALUES ('320113', '320100', '栖霞区', '3');
INSERT INTO `area_info` VALUES ('320114', '320100', '雨花台区', '3');
INSERT INTO `area_info` VALUES ('320115', '320100', '江宁区', '3');
INSERT INTO `area_info` VALUES ('320116', '320100', '六合区', '3');
INSERT INTO `area_info` VALUES ('320117', '320100', '溧水区', '3');
INSERT INTO `area_info` VALUES ('320118', '320100', '高淳区', '3');
INSERT INTO `area_info` VALUES ('320200', '320000', '无锡市', '2');
INSERT INTO `area_info` VALUES ('320201', '320200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320205', '320200', '锡山区', '3');
INSERT INTO `area_info` VALUES ('320206', '320200', '惠山区', '3');
INSERT INTO `area_info` VALUES ('320211', '320200', '滨湖区', '3');
INSERT INTO `area_info` VALUES ('320213', '320200', '梁溪区', '3');
INSERT INTO `area_info` VALUES ('320214', '320200', '新吴区', '3');
INSERT INTO `area_info` VALUES ('320281', '320200', '江阴市', '3');
INSERT INTO `area_info` VALUES ('320282', '320200', '宜兴市', '3');
INSERT INTO `area_info` VALUES ('320300', '320000', '徐州市', '2');
INSERT INTO `area_info` VALUES ('320301', '320300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320302', '320300', '鼓楼区', '3');
INSERT INTO `area_info` VALUES ('320303', '320300', '云龙区', '3');
INSERT INTO `area_info` VALUES ('320305', '320300', '贾汪区', '3');
INSERT INTO `area_info` VALUES ('320311', '320300', '泉山区', '3');
INSERT INTO `area_info` VALUES ('320312', '320300', '铜山区', '3');
INSERT INTO `area_info` VALUES ('320321', '320300', '丰县', '3');
INSERT INTO `area_info` VALUES ('320322', '320300', '沛县', '3');
INSERT INTO `area_info` VALUES ('320324', '320300', '睢宁县', '3');
INSERT INTO `area_info` VALUES ('320381', '320300', '新沂市', '3');
INSERT INTO `area_info` VALUES ('320382', '320300', '邳州市', '3');
INSERT INTO `area_info` VALUES ('320400', '320000', '常州市', '2');
INSERT INTO `area_info` VALUES ('320401', '320400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320402', '320400', '天宁区', '3');
INSERT INTO `area_info` VALUES ('320404', '320400', '钟楼区', '3');
INSERT INTO `area_info` VALUES ('320411', '320400', '新北区', '3');
INSERT INTO `area_info` VALUES ('320412', '320400', '武进区', '3');
INSERT INTO `area_info` VALUES ('320413', '320400', '金坛区', '3');
INSERT INTO `area_info` VALUES ('320481', '320400', '溧阳市', '3');
INSERT INTO `area_info` VALUES ('320500', '320000', '苏州市', '2');
INSERT INTO `area_info` VALUES ('320501', '320500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320505', '320500', '虎丘区', '3');
INSERT INTO `area_info` VALUES ('320506', '320500', '吴中区', '3');
INSERT INTO `area_info` VALUES ('320507', '320500', '相城区', '3');
INSERT INTO `area_info` VALUES ('320508', '320500', '姑苏区', '3');
INSERT INTO `area_info` VALUES ('320509', '320500', '吴江区', '3');
INSERT INTO `area_info` VALUES ('320581', '320500', '常熟市', '3');
INSERT INTO `area_info` VALUES ('320582', '320500', '张家港市', '3');
INSERT INTO `area_info` VALUES ('320583', '320500', '昆山市', '3');
INSERT INTO `area_info` VALUES ('320585', '320500', '太仓市', '3');
INSERT INTO `area_info` VALUES ('320600', '320000', '南通市', '2');
INSERT INTO `area_info` VALUES ('320601', '320600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320602', '320600', '崇川区', '3');
INSERT INTO `area_info` VALUES ('320611', '320600', '港闸区', '3');
INSERT INTO `area_info` VALUES ('320612', '320600', '通州区', '3');
INSERT INTO `area_info` VALUES ('320621', '320600', '海安县', '3');
INSERT INTO `area_info` VALUES ('320623', '320600', '如东县', '3');
INSERT INTO `area_info` VALUES ('320681', '320600', '启东市', '3');
INSERT INTO `area_info` VALUES ('320682', '320600', '如皋市', '3');
INSERT INTO `area_info` VALUES ('320684', '320600', '海门市', '3');
INSERT INTO `area_info` VALUES ('320700', '320000', '连云港市', '2');
INSERT INTO `area_info` VALUES ('320701', '320700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320703', '320700', '连云区', '3');
INSERT INTO `area_info` VALUES ('320706', '320700', '海州区', '3');
INSERT INTO `area_info` VALUES ('320707', '320700', '赣榆区', '3');
INSERT INTO `area_info` VALUES ('320722', '320700', '东海县', '3');
INSERT INTO `area_info` VALUES ('320723', '320700', '灌云县', '3');
INSERT INTO `area_info` VALUES ('320724', '320700', '灌南县', '3');
INSERT INTO `area_info` VALUES ('320800', '320000', '淮安市', '2');
INSERT INTO `area_info` VALUES ('320801', '320800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320803', '320800', '淮安区', '3');
INSERT INTO `area_info` VALUES ('320804', '320800', '淮阴区', '3');
INSERT INTO `area_info` VALUES ('320812', '320800', '清江浦区', '3');
INSERT INTO `area_info` VALUES ('320813', '320800', '洪泽区', '3');
INSERT INTO `area_info` VALUES ('320826', '320800', '涟水县', '3');
INSERT INTO `area_info` VALUES ('320830', '320800', '盱眙县', '3');
INSERT INTO `area_info` VALUES ('320831', '320800', '金湖县', '3');
INSERT INTO `area_info` VALUES ('320900', '320000', '盐城市', '2');
INSERT INTO `area_info` VALUES ('320901', '320900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('320902', '320900', '亭湖区', '3');
INSERT INTO `area_info` VALUES ('320903', '320900', '盐都区', '3');
INSERT INTO `area_info` VALUES ('320904', '320900', '大丰区', '3');
INSERT INTO `area_info` VALUES ('320921', '320900', '响水县', '3');
INSERT INTO `area_info` VALUES ('320922', '320900', '滨海县', '3');
INSERT INTO `area_info` VALUES ('320923', '320900', '阜宁县', '3');
INSERT INTO `area_info` VALUES ('320924', '320900', '射阳县', '3');
INSERT INTO `area_info` VALUES ('320925', '320900', '建湖县', '3');
INSERT INTO `area_info` VALUES ('320981', '320900', '东台市', '3');
INSERT INTO `area_info` VALUES ('321000', '320000', '扬州市', '2');
INSERT INTO `area_info` VALUES ('321001', '321000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('321002', '321000', '广陵区', '3');
INSERT INTO `area_info` VALUES ('321003', '321000', '邗江区', '3');
INSERT INTO `area_info` VALUES ('321012', '321000', '江都区', '3');
INSERT INTO `area_info` VALUES ('321023', '321000', '宝应县', '3');
INSERT INTO `area_info` VALUES ('321081', '321000', '仪征市', '3');
INSERT INTO `area_info` VALUES ('321084', '321000', '高邮市', '3');
INSERT INTO `area_info` VALUES ('321100', '320000', '镇江市', '2');
INSERT INTO `area_info` VALUES ('321101', '321100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('321102', '321100', '京口区', '3');
INSERT INTO `area_info` VALUES ('321111', '321100', '润州区', '3');
INSERT INTO `area_info` VALUES ('321112', '321100', '丹徒区', '3');
INSERT INTO `area_info` VALUES ('321181', '321100', '丹阳市', '3');
INSERT INTO `area_info` VALUES ('321182', '321100', '扬中市', '3');
INSERT INTO `area_info` VALUES ('321183', '321100', '句容市', '3');
INSERT INTO `area_info` VALUES ('321200', '320000', '泰州市', '2');
INSERT INTO `area_info` VALUES ('321201', '321200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('321202', '321200', '海陵区', '3');
INSERT INTO `area_info` VALUES ('321203', '321200', '高港区', '3');
INSERT INTO `area_info` VALUES ('321204', '321200', '姜堰区', '3');
INSERT INTO `area_info` VALUES ('321281', '321200', '兴化市', '3');
INSERT INTO `area_info` VALUES ('321282', '321200', '靖江市', '3');
INSERT INTO `area_info` VALUES ('321283', '321200', '泰兴市', '3');
INSERT INTO `area_info` VALUES ('321300', '320000', '宿迁市', '2');
INSERT INTO `area_info` VALUES ('321301', '321300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('321302', '321300', '宿城区', '3');
INSERT INTO `area_info` VALUES ('321311', '321300', '宿豫区', '3');
INSERT INTO `area_info` VALUES ('321322', '321300', '沭阳县', '3');
INSERT INTO `area_info` VALUES ('321323', '321300', '泗阳县', '3');
INSERT INTO `area_info` VALUES ('321324', '321300', '泗洪县', '3');
INSERT INTO `area_info` VALUES ('330000', null, '浙江省', '1');
INSERT INTO `area_info` VALUES ('330100', '330000', '杭州市', '2');
INSERT INTO `area_info` VALUES ('330101', '330100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330102', '330100', '上城区', '3');
INSERT INTO `area_info` VALUES ('330103', '330100', '下城区', '3');
INSERT INTO `area_info` VALUES ('330104', '330100', '江干区', '3');
INSERT INTO `area_info` VALUES ('330105', '330100', '拱墅区', '3');
INSERT INTO `area_info` VALUES ('330106', '330100', '西湖区', '3');
INSERT INTO `area_info` VALUES ('330108', '330100', '滨江区', '3');
INSERT INTO `area_info` VALUES ('330109', '330100', '萧山区', '3');
INSERT INTO `area_info` VALUES ('330110', '330100', '余杭区', '3');
INSERT INTO `area_info` VALUES ('330111', '330100', '富阳区', '3');
INSERT INTO `area_info` VALUES ('330122', '330100', '桐庐县', '3');
INSERT INTO `area_info` VALUES ('330127', '330100', '淳安县', '3');
INSERT INTO `area_info` VALUES ('330182', '330100', '建德市', '3');
INSERT INTO `area_info` VALUES ('330185', '330100', '临安市', '3');
INSERT INTO `area_info` VALUES ('330200', '330000', '宁波市', '2');
INSERT INTO `area_info` VALUES ('330201', '330200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330203', '330200', '海曙区', '3');
INSERT INTO `area_info` VALUES ('330204', '330200', '江东区', '3');
INSERT INTO `area_info` VALUES ('330205', '330200', '江北区', '3');
INSERT INTO `area_info` VALUES ('330206', '330200', '北仑区', '3');
INSERT INTO `area_info` VALUES ('330211', '330200', '镇海区', '3');
INSERT INTO `area_info` VALUES ('330212', '330200', '鄞州区', '3');
INSERT INTO `area_info` VALUES ('330225', '330200', '象山县', '3');
INSERT INTO `area_info` VALUES ('330226', '330200', '宁海县', '3');
INSERT INTO `area_info` VALUES ('330281', '330200', '余姚市', '3');
INSERT INTO `area_info` VALUES ('330282', '330200', '慈溪市', '3');
INSERT INTO `area_info` VALUES ('330283', '330200', '奉化市', '3');
INSERT INTO `area_info` VALUES ('330300', '330000', '温州市', '2');
INSERT INTO `area_info` VALUES ('330301', '330300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330302', '330300', '鹿城区', '3');
INSERT INTO `area_info` VALUES ('330303', '330300', '龙湾区', '3');
INSERT INTO `area_info` VALUES ('330304', '330300', '瓯海区', '3');
INSERT INTO `area_info` VALUES ('330305', '330300', '洞头区', '3');
INSERT INTO `area_info` VALUES ('330324', '330300', '永嘉县', '3');
INSERT INTO `area_info` VALUES ('330326', '330300', '平阳县', '3');
INSERT INTO `area_info` VALUES ('330327', '330300', '苍南县', '3');
INSERT INTO `area_info` VALUES ('330328', '330300', '文成县', '3');
INSERT INTO `area_info` VALUES ('330329', '330300', '泰顺县', '3');
INSERT INTO `area_info` VALUES ('330381', '330300', '瑞安市', '3');
INSERT INTO `area_info` VALUES ('330382', '330300', '乐清市', '3');
INSERT INTO `area_info` VALUES ('330400', '330000', '嘉兴市', '2');
INSERT INTO `area_info` VALUES ('330401', '330400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330402', '330400', '南湖区', '3');
INSERT INTO `area_info` VALUES ('330411', '330400', '秀洲区', '3');
INSERT INTO `area_info` VALUES ('330421', '330400', '嘉善县', '3');
INSERT INTO `area_info` VALUES ('330424', '330400', '海盐县', '3');
INSERT INTO `area_info` VALUES ('330481', '330400', '海宁市', '3');
INSERT INTO `area_info` VALUES ('330482', '330400', '平湖市', '3');
INSERT INTO `area_info` VALUES ('330483', '330400', '桐乡市', '3');
INSERT INTO `area_info` VALUES ('330500', '330000', '湖州市', '2');
INSERT INTO `area_info` VALUES ('330501', '330500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330502', '330500', '吴兴区', '3');
INSERT INTO `area_info` VALUES ('330503', '330500', '南浔区', '3');
INSERT INTO `area_info` VALUES ('330521', '330500', '德清县', '3');
INSERT INTO `area_info` VALUES ('330522', '330500', '长兴县', '3');
INSERT INTO `area_info` VALUES ('330523', '330500', '安吉县', '3');
INSERT INTO `area_info` VALUES ('330600', '330000', '绍兴市', '2');
INSERT INTO `area_info` VALUES ('330601', '330600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330602', '330600', '越城区', '3');
INSERT INTO `area_info` VALUES ('330603', '330600', '柯桥区', '3');
INSERT INTO `area_info` VALUES ('330604', '330600', '上虞区', '3');
INSERT INTO `area_info` VALUES ('330624', '330600', '新昌县', '3');
INSERT INTO `area_info` VALUES ('330681', '330600', '诸暨市', '3');
INSERT INTO `area_info` VALUES ('330683', '330600', '嵊州市', '3');
INSERT INTO `area_info` VALUES ('330700', '330000', '金华市', '2');
INSERT INTO `area_info` VALUES ('330701', '330700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330702', '330700', '婺城区', '3');
INSERT INTO `area_info` VALUES ('330703', '330700', '金东区', '3');
INSERT INTO `area_info` VALUES ('330723', '330700', '武义县', '3');
INSERT INTO `area_info` VALUES ('330726', '330700', '浦江县', '3');
INSERT INTO `area_info` VALUES ('330727', '330700', '磐安县', '3');
INSERT INTO `area_info` VALUES ('330781', '330700', '兰溪市', '3');
INSERT INTO `area_info` VALUES ('330782', '330700', '义乌市', '3');
INSERT INTO `area_info` VALUES ('330783', '330700', '东阳市', '3');
INSERT INTO `area_info` VALUES ('330784', '330700', '永康市', '3');
INSERT INTO `area_info` VALUES ('330800', '330000', '衢州市', '2');
INSERT INTO `area_info` VALUES ('330801', '330800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330802', '330800', '柯城区', '3');
INSERT INTO `area_info` VALUES ('330803', '330800', '衢江区', '3');
INSERT INTO `area_info` VALUES ('330822', '330800', '常山县', '3');
INSERT INTO `area_info` VALUES ('330824', '330800', '开化县', '3');
INSERT INTO `area_info` VALUES ('330825', '330800', '龙游县', '3');
INSERT INTO `area_info` VALUES ('330881', '330800', '江山市', '3');
INSERT INTO `area_info` VALUES ('330900', '330000', '舟山市', '2');
INSERT INTO `area_info` VALUES ('330901', '330900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('330902', '330900', '定海区', '3');
INSERT INTO `area_info` VALUES ('330903', '330900', '普陀区', '3');
INSERT INTO `area_info` VALUES ('330921', '330900', '岱山县', '3');
INSERT INTO `area_info` VALUES ('330922', '330900', '嵊泗县', '3');
INSERT INTO `area_info` VALUES ('331000', '330000', '台州市', '2');
INSERT INTO `area_info` VALUES ('331001', '331000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('331002', '331000', '椒江区', '3');
INSERT INTO `area_info` VALUES ('331003', '331000', '黄岩区', '3');
INSERT INTO `area_info` VALUES ('331004', '331000', '路桥区', '3');
INSERT INTO `area_info` VALUES ('331021', '331000', '玉环县', '3');
INSERT INTO `area_info` VALUES ('331022', '331000', '三门县', '3');
INSERT INTO `area_info` VALUES ('331023', '331000', '天台县', '3');
INSERT INTO `area_info` VALUES ('331024', '331000', '仙居县', '3');
INSERT INTO `area_info` VALUES ('331081', '331000', '温岭市', '3');
INSERT INTO `area_info` VALUES ('331082', '331000', '临海市', '3');
INSERT INTO `area_info` VALUES ('331100', '330000', '丽水市', '2');
INSERT INTO `area_info` VALUES ('331101', '331100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('331102', '331100', '莲都区', '3');
INSERT INTO `area_info` VALUES ('331121', '331100', '青田县', '3');
INSERT INTO `area_info` VALUES ('331122', '331100', '缙云县', '3');
INSERT INTO `area_info` VALUES ('331123', '331100', '遂昌县', '3');
INSERT INTO `area_info` VALUES ('331124', '331100', '松阳县', '3');
INSERT INTO `area_info` VALUES ('331125', '331100', '云和县', '3');
INSERT INTO `area_info` VALUES ('331126', '331100', '庆元县', '3');
INSERT INTO `area_info` VALUES ('331127', '331100', '景宁畲族自治县', '3');
INSERT INTO `area_info` VALUES ('331181', '331100', '龙泉市', '3');
INSERT INTO `area_info` VALUES ('340000', null, '安徽省', '1');
INSERT INTO `area_info` VALUES ('340100', '340000', '合肥市', '2');
INSERT INTO `area_info` VALUES ('340101', '340100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340102', '340100', '瑶海区', '3');
INSERT INTO `area_info` VALUES ('340103', '340100', '庐阳区', '3');
INSERT INTO `area_info` VALUES ('340104', '340100', '蜀山区', '3');
INSERT INTO `area_info` VALUES ('340111', '340100', '包河区', '3');
INSERT INTO `area_info` VALUES ('340121', '340100', '长丰县', '3');
INSERT INTO `area_info` VALUES ('340122', '340100', '肥东县', '3');
INSERT INTO `area_info` VALUES ('340123', '340100', '肥西县', '3');
INSERT INTO `area_info` VALUES ('340124', '340100', '庐江县', '3');
INSERT INTO `area_info` VALUES ('340181', '340100', '巢湖市', '3');
INSERT INTO `area_info` VALUES ('340200', '340000', '芜湖市', '2');
INSERT INTO `area_info` VALUES ('340201', '340200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340202', '340200', '镜湖区', '3');
INSERT INTO `area_info` VALUES ('340203', '340200', '弋江区', '3');
INSERT INTO `area_info` VALUES ('340207', '340200', '鸠江区', '3');
INSERT INTO `area_info` VALUES ('340208', '340200', '三山区', '3');
INSERT INTO `area_info` VALUES ('340221', '340200', '芜湖县', '3');
INSERT INTO `area_info` VALUES ('340222', '340200', '繁昌县', '3');
INSERT INTO `area_info` VALUES ('340223', '340200', '南陵县', '3');
INSERT INTO `area_info` VALUES ('340225', '340200', '无为县', '3');
INSERT INTO `area_info` VALUES ('340300', '340000', '蚌埠市', '2');
INSERT INTO `area_info` VALUES ('340301', '340300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340302', '340300', '龙子湖区', '3');
INSERT INTO `area_info` VALUES ('340303', '340300', '蚌山区', '3');
INSERT INTO `area_info` VALUES ('340304', '340300', '禹会区', '3');
INSERT INTO `area_info` VALUES ('340311', '340300', '淮上区', '3');
INSERT INTO `area_info` VALUES ('340321', '340300', '怀远县', '3');
INSERT INTO `area_info` VALUES ('340322', '340300', '五河县', '3');
INSERT INTO `area_info` VALUES ('340323', '340300', '固镇县', '3');
INSERT INTO `area_info` VALUES ('340400', '340000', '淮南市', '2');
INSERT INTO `area_info` VALUES ('340401', '340400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340402', '340400', '大通区', '3');
INSERT INTO `area_info` VALUES ('340403', '340400', '田家庵区', '3');
INSERT INTO `area_info` VALUES ('340404', '340400', '谢家集区', '3');
INSERT INTO `area_info` VALUES ('340405', '340400', '八公山区', '3');
INSERT INTO `area_info` VALUES ('340406', '340400', '潘集区', '3');
INSERT INTO `area_info` VALUES ('340421', '340400', '凤台县', '3');
INSERT INTO `area_info` VALUES ('340422', '340400', '寿县', '3');
INSERT INTO `area_info` VALUES ('340500', '340000', '马鞍山市', '2');
INSERT INTO `area_info` VALUES ('340501', '340500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340503', '340500', '花山区', '3');
INSERT INTO `area_info` VALUES ('340504', '340500', '雨山区', '3');
INSERT INTO `area_info` VALUES ('340506', '340500', '博望区', '3');
INSERT INTO `area_info` VALUES ('340521', '340500', '当涂县', '3');
INSERT INTO `area_info` VALUES ('340522', '340500', '含山县', '3');
INSERT INTO `area_info` VALUES ('340523', '340500', '和县', '3');
INSERT INTO `area_info` VALUES ('340600', '340000', '淮北市', '2');
INSERT INTO `area_info` VALUES ('340601', '340600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340602', '340600', '杜集区', '3');
INSERT INTO `area_info` VALUES ('340603', '340600', '相山区', '3');
INSERT INTO `area_info` VALUES ('340604', '340600', '烈山区', '3');
INSERT INTO `area_info` VALUES ('340621', '340600', '濉溪县', '3');
INSERT INTO `area_info` VALUES ('340700', '340000', '铜陵市', '2');
INSERT INTO `area_info` VALUES ('340701', '340700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340705', '340700', '铜官区', '3');
INSERT INTO `area_info` VALUES ('340706', '340700', '义安区', '3');
INSERT INTO `area_info` VALUES ('340711', '340700', '郊区', '3');
INSERT INTO `area_info` VALUES ('340722', '340700', '枞阳县', '3');
INSERT INTO `area_info` VALUES ('340800', '340000', '安庆市', '2');
INSERT INTO `area_info` VALUES ('340801', '340800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('340802', '340800', '迎江区', '3');
INSERT INTO `area_info` VALUES ('340803', '340800', '大观区', '3');
INSERT INTO `area_info` VALUES ('340811', '340800', '宜秀区', '3');
INSERT INTO `area_info` VALUES ('340822', '340800', '怀宁县', '3');
INSERT INTO `area_info` VALUES ('340824', '340800', '潜山县', '3');
INSERT INTO `area_info` VALUES ('340825', '340800', '太湖县', '3');
INSERT INTO `area_info` VALUES ('340826', '340800', '宿松县', '3');
INSERT INTO `area_info` VALUES ('340827', '340800', '望江县', '3');
INSERT INTO `area_info` VALUES ('340828', '340800', '岳西县', '3');
INSERT INTO `area_info` VALUES ('340881', '340800', '桐城市', '3');
INSERT INTO `area_info` VALUES ('341000', '340000', '黄山市', '2');
INSERT INTO `area_info` VALUES ('341001', '341000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341002', '341000', '屯溪区', '3');
INSERT INTO `area_info` VALUES ('341003', '341000', '黄山区', '3');
INSERT INTO `area_info` VALUES ('341004', '341000', '徽州区', '3');
INSERT INTO `area_info` VALUES ('341021', '341000', '歙县', '3');
INSERT INTO `area_info` VALUES ('341022', '341000', '休宁县', '3');
INSERT INTO `area_info` VALUES ('341023', '341000', '黟县', '3');
INSERT INTO `area_info` VALUES ('341024', '341000', '祁门县', '3');
INSERT INTO `area_info` VALUES ('341100', '340000', '滁州市', '2');
INSERT INTO `area_info` VALUES ('341101', '341100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341102', '341100', '琅琊区', '3');
INSERT INTO `area_info` VALUES ('341103', '341100', '南谯区', '3');
INSERT INTO `area_info` VALUES ('341122', '341100', '来安县', '3');
INSERT INTO `area_info` VALUES ('341124', '341100', '全椒县', '3');
INSERT INTO `area_info` VALUES ('341125', '341100', '定远县', '3');
INSERT INTO `area_info` VALUES ('341126', '341100', '凤阳县', '3');
INSERT INTO `area_info` VALUES ('341181', '341100', '天长市', '3');
INSERT INTO `area_info` VALUES ('341182', '341100', '明光市', '3');
INSERT INTO `area_info` VALUES ('341200', '340000', '阜阳市', '2');
INSERT INTO `area_info` VALUES ('341201', '341200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341202', '341200', '颍州区', '3');
INSERT INTO `area_info` VALUES ('341203', '341200', '颍东区', '3');
INSERT INTO `area_info` VALUES ('341204', '341200', '颍泉区', '3');
INSERT INTO `area_info` VALUES ('341221', '341200', '临泉县', '3');
INSERT INTO `area_info` VALUES ('341222', '341200', '太和县', '3');
INSERT INTO `area_info` VALUES ('341225', '341200', '阜南县', '3');
INSERT INTO `area_info` VALUES ('341226', '341200', '颍上县', '3');
INSERT INTO `area_info` VALUES ('341282', '341200', '界首市', '3');
INSERT INTO `area_info` VALUES ('341300', '340000', '宿州市', '2');
INSERT INTO `area_info` VALUES ('341301', '341300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341302', '341300', '埇桥区', '3');
INSERT INTO `area_info` VALUES ('341321', '341300', '砀山县', '3');
INSERT INTO `area_info` VALUES ('341322', '341300', '萧县', '3');
INSERT INTO `area_info` VALUES ('341323', '341300', '灵璧县', '3');
INSERT INTO `area_info` VALUES ('341324', '341300', '泗县', '3');
INSERT INTO `area_info` VALUES ('341500', '340000', '六安市', '2');
INSERT INTO `area_info` VALUES ('341501', '341500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341502', '341500', '金安区', '3');
INSERT INTO `area_info` VALUES ('341503', '341500', '裕安区', '3');
INSERT INTO `area_info` VALUES ('341504', '341500', '叶集区', '3');
INSERT INTO `area_info` VALUES ('341522', '341500', '霍邱县', '3');
INSERT INTO `area_info` VALUES ('341523', '341500', '舒城县', '3');
INSERT INTO `area_info` VALUES ('341524', '341500', '金寨县', '3');
INSERT INTO `area_info` VALUES ('341525', '341500', '霍山县', '3');
INSERT INTO `area_info` VALUES ('341600', '340000', '亳州市', '2');
INSERT INTO `area_info` VALUES ('341601', '341600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341602', '341600', '谯城区', '3');
INSERT INTO `area_info` VALUES ('341621', '341600', '涡阳县', '3');
INSERT INTO `area_info` VALUES ('341622', '341600', '蒙城县', '3');
INSERT INTO `area_info` VALUES ('341623', '341600', '利辛县', '3');
INSERT INTO `area_info` VALUES ('341700', '340000', '池州市', '2');
INSERT INTO `area_info` VALUES ('341701', '341700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341702', '341700', '贵池区', '3');
INSERT INTO `area_info` VALUES ('341721', '341700', '东至县', '3');
INSERT INTO `area_info` VALUES ('341722', '341700', '石台县', '3');
INSERT INTO `area_info` VALUES ('341723', '341700', '青阳县', '3');
INSERT INTO `area_info` VALUES ('341800', '340000', '宣城市', '2');
INSERT INTO `area_info` VALUES ('341801', '341800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('341802', '341800', '宣州区', '3');
INSERT INTO `area_info` VALUES ('341821', '341800', '郎溪县', '3');
INSERT INTO `area_info` VALUES ('341822', '341800', '广德县', '3');
INSERT INTO `area_info` VALUES ('341823', '341800', '泾县', '3');
INSERT INTO `area_info` VALUES ('341824', '341800', '绩溪县', '3');
INSERT INTO `area_info` VALUES ('341825', '341800', '旌德县', '3');
INSERT INTO `area_info` VALUES ('341881', '341800', '宁国市', '3');
INSERT INTO `area_info` VALUES ('350000', null, '福建省', '1');
INSERT INTO `area_info` VALUES ('350100', '350000', '福州市', '2');
INSERT INTO `area_info` VALUES ('350101', '350100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350102', '350100', '鼓楼区', '3');
INSERT INTO `area_info` VALUES ('350103', '350100', '台江区', '3');
INSERT INTO `area_info` VALUES ('350104', '350100', '仓山区', '3');
INSERT INTO `area_info` VALUES ('350105', '350100', '马尾区', '3');
INSERT INTO `area_info` VALUES ('350111', '350100', '晋安区', '3');
INSERT INTO `area_info` VALUES ('350121', '350100', '闽侯县', '3');
INSERT INTO `area_info` VALUES ('350122', '350100', '连江县', '3');
INSERT INTO `area_info` VALUES ('350123', '350100', '罗源县', '3');
INSERT INTO `area_info` VALUES ('350124', '350100', '闽清县', '3');
INSERT INTO `area_info` VALUES ('350125', '350100', '永泰县', '3');
INSERT INTO `area_info` VALUES ('350128', '350100', '平潭县', '3');
INSERT INTO `area_info` VALUES ('350181', '350100', '福清市', '3');
INSERT INTO `area_info` VALUES ('350182', '350100', '长乐市', '3');
INSERT INTO `area_info` VALUES ('350200', '350000', '厦门市', '2');
INSERT INTO `area_info` VALUES ('350201', '350200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350203', '350200', '思明区', '3');
INSERT INTO `area_info` VALUES ('350205', '350200', '海沧区', '3');
INSERT INTO `area_info` VALUES ('350206', '350200', '湖里区', '3');
INSERT INTO `area_info` VALUES ('350211', '350200', '集美区', '3');
INSERT INTO `area_info` VALUES ('350212', '350200', '同安区', '3');
INSERT INTO `area_info` VALUES ('350213', '350200', '翔安区', '3');
INSERT INTO `area_info` VALUES ('350300', '350000', '莆田市', '2');
INSERT INTO `area_info` VALUES ('350301', '350300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350302', '350300', '城厢区', '3');
INSERT INTO `area_info` VALUES ('350303', '350300', '涵江区', '3');
INSERT INTO `area_info` VALUES ('350304', '350300', '荔城区', '3');
INSERT INTO `area_info` VALUES ('350305', '350300', '秀屿区', '3');
INSERT INTO `area_info` VALUES ('350322', '350300', '仙游县', '3');
INSERT INTO `area_info` VALUES ('350400', '350000', '三明市', '2');
INSERT INTO `area_info` VALUES ('350401', '350400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350402', '350400', '梅列区', '3');
INSERT INTO `area_info` VALUES ('350403', '350400', '三元区', '3');
INSERT INTO `area_info` VALUES ('350421', '350400', '明溪县', '3');
INSERT INTO `area_info` VALUES ('350423', '350400', '清流县', '3');
INSERT INTO `area_info` VALUES ('350424', '350400', '宁化县', '3');
INSERT INTO `area_info` VALUES ('350425', '350400', '大田县', '3');
INSERT INTO `area_info` VALUES ('350426', '350400', '尤溪县', '3');
INSERT INTO `area_info` VALUES ('350427', '350400', '沙县', '3');
INSERT INTO `area_info` VALUES ('350428', '350400', '将乐县', '3');
INSERT INTO `area_info` VALUES ('350429', '350400', '泰宁县', '3');
INSERT INTO `area_info` VALUES ('350430', '350400', '建宁县', '3');
INSERT INTO `area_info` VALUES ('350481', '350400', '永安市', '3');
INSERT INTO `area_info` VALUES ('350500', '350000', '泉州市', '2');
INSERT INTO `area_info` VALUES ('350501', '350500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350502', '350500', '鲤城区', '3');
INSERT INTO `area_info` VALUES ('350503', '350500', '丰泽区', '3');
INSERT INTO `area_info` VALUES ('350504', '350500', '洛江区', '3');
INSERT INTO `area_info` VALUES ('350505', '350500', '泉港区', '3');
INSERT INTO `area_info` VALUES ('350521', '350500', '惠安县', '3');
INSERT INTO `area_info` VALUES ('350524', '350500', '安溪县', '3');
INSERT INTO `area_info` VALUES ('350525', '350500', '永春县', '3');
INSERT INTO `area_info` VALUES ('350526', '350500', '德化县', '3');
INSERT INTO `area_info` VALUES ('350527', '350500', '金门县', '3');
INSERT INTO `area_info` VALUES ('350581', '350500', '石狮市', '3');
INSERT INTO `area_info` VALUES ('350582', '350500', '晋江市', '3');
INSERT INTO `area_info` VALUES ('350583', '350500', '南安市', '3');
INSERT INTO `area_info` VALUES ('350600', '350000', '漳州市', '2');
INSERT INTO `area_info` VALUES ('350601', '350600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350602', '350600', '芗城区', '3');
INSERT INTO `area_info` VALUES ('350603', '350600', '龙文区', '3');
INSERT INTO `area_info` VALUES ('350622', '350600', '云霄县', '3');
INSERT INTO `area_info` VALUES ('350623', '350600', '漳浦县', '3');
INSERT INTO `area_info` VALUES ('350624', '350600', '诏安县', '3');
INSERT INTO `area_info` VALUES ('350625', '350600', '长泰县', '3');
INSERT INTO `area_info` VALUES ('350626', '350600', '东山县', '3');
INSERT INTO `area_info` VALUES ('350627', '350600', '南靖县', '3');
INSERT INTO `area_info` VALUES ('350628', '350600', '平和县', '3');
INSERT INTO `area_info` VALUES ('350629', '350600', '华安县', '3');
INSERT INTO `area_info` VALUES ('350681', '350600', '龙海市', '3');
INSERT INTO `area_info` VALUES ('350700', '350000', '南平市', '2');
INSERT INTO `area_info` VALUES ('350701', '350700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350702', '350700', '延平区', '3');
INSERT INTO `area_info` VALUES ('350703', '350700', '建阳区', '3');
INSERT INTO `area_info` VALUES ('350721', '350700', '顺昌县', '3');
INSERT INTO `area_info` VALUES ('350722', '350700', '浦城县', '3');
INSERT INTO `area_info` VALUES ('350723', '350700', '光泽县', '3');
INSERT INTO `area_info` VALUES ('350724', '350700', '松溪县', '3');
INSERT INTO `area_info` VALUES ('350725', '350700', '政和县', '3');
INSERT INTO `area_info` VALUES ('350781', '350700', '邵武市', '3');
INSERT INTO `area_info` VALUES ('350782', '350700', '武夷山市', '3');
INSERT INTO `area_info` VALUES ('350783', '350700', '建瓯市', '3');
INSERT INTO `area_info` VALUES ('350800', '350000', '龙岩市', '2');
INSERT INTO `area_info` VALUES ('350801', '350800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('350802', '350800', '新罗区', '3');
INSERT INTO `area_info` VALUES ('350803', '350800', '永定区', '3');
INSERT INTO `area_info` VALUES ('350821', '350800', '长汀县', '3');
INSERT INTO `area_info` VALUES ('350823', '350800', '上杭县', '3');
INSERT INTO `area_info` VALUES ('350824', '350800', '武平县', '3');
INSERT INTO `area_info` VALUES ('350825', '350800', '连城县', '3');
INSERT INTO `area_info` VALUES ('350881', '350800', '漳平市', '3');
INSERT INTO `area_info` VALUES ('350900', '350000', '宁德市', '2');
INSERT INTO `area_info` VALUES ('350901', '350900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360000', null, '江西省', '1');
INSERT INTO `area_info` VALUES ('360100', '360000', '南昌市', '2');
INSERT INTO `area_info` VALUES ('360101', '360100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360102', '360100', '东湖区', '3');
INSERT INTO `area_info` VALUES ('360103', '360100', '西湖区', '3');
INSERT INTO `area_info` VALUES ('360104', '360100', '青云谱区', '3');
INSERT INTO `area_info` VALUES ('360105', '360100', '湾里区', '3');
INSERT INTO `area_info` VALUES ('360111', '360100', '青山湖区', '3');
INSERT INTO `area_info` VALUES ('360112', '360100', '新建区', '3');
INSERT INTO `area_info` VALUES ('360121', '360100', '南昌县', '3');
INSERT INTO `area_info` VALUES ('360123', '360100', '安义县', '3');
INSERT INTO `area_info` VALUES ('360124', '360100', '进贤县', '3');
INSERT INTO `area_info` VALUES ('360200', '360000', '景德镇市', '2');
INSERT INTO `area_info` VALUES ('360201', '360200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360202', '360200', '昌江区', '3');
INSERT INTO `area_info` VALUES ('360203', '360200', '珠山区', '3');
INSERT INTO `area_info` VALUES ('360222', '360200', '浮梁县', '3');
INSERT INTO `area_info` VALUES ('360281', '360200', '乐平市', '3');
INSERT INTO `area_info` VALUES ('360300', '360000', '萍乡市', '2');
INSERT INTO `area_info` VALUES ('360301', '360300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360302', '360300', '安源区', '3');
INSERT INTO `area_info` VALUES ('360313', '360300', '湘东区', '3');
INSERT INTO `area_info` VALUES ('360321', '360300', '莲花县', '3');
INSERT INTO `area_info` VALUES ('360322', '360300', '上栗县', '3');
INSERT INTO `area_info` VALUES ('360323', '360300', '芦溪县', '3');
INSERT INTO `area_info` VALUES ('360400', '360000', '九江市', '2');
INSERT INTO `area_info` VALUES ('360401', '360400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360402', '360400', '濂溪区', '3');
INSERT INTO `area_info` VALUES ('360403', '360400', '浔阳区', '3');
INSERT INTO `area_info` VALUES ('360421', '360400', '九江县', '3');
INSERT INTO `area_info` VALUES ('360423', '360400', '武宁县', '3');
INSERT INTO `area_info` VALUES ('360424', '360400', '修水县', '3');
INSERT INTO `area_info` VALUES ('360425', '360400', '永修县', '3');
INSERT INTO `area_info` VALUES ('360426', '360400', '德安县', '3');
INSERT INTO `area_info` VALUES ('360428', '360400', '都昌县', '3');
INSERT INTO `area_info` VALUES ('360429', '360400', '湖口县', '3');
INSERT INTO `area_info` VALUES ('360430', '360400', '彭泽县', '3');
INSERT INTO `area_info` VALUES ('360481', '360400', '瑞昌市', '3');
INSERT INTO `area_info` VALUES ('360482', '360400', '共青城市', '3');
INSERT INTO `area_info` VALUES ('360483', '360400', '庐山市', '3');
INSERT INTO `area_info` VALUES ('360500', '360000', '新余市', '2');
INSERT INTO `area_info` VALUES ('360501', '360500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360502', '360500', '渝水区', '3');
INSERT INTO `area_info` VALUES ('360521', '360500', '分宜县', '3');
INSERT INTO `area_info` VALUES ('360600', '360000', '鹰潭市', '2');
INSERT INTO `area_info` VALUES ('360601', '360600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360602', '360600', '月湖区', '3');
INSERT INTO `area_info` VALUES ('360622', '360600', '余江县', '3');
INSERT INTO `area_info` VALUES ('360681', '360600', '贵溪市', '3');
INSERT INTO `area_info` VALUES ('360700', '360000', '赣州市', '2');
INSERT INTO `area_info` VALUES ('360701', '360700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360702', '360700', '章贡区', '3');
INSERT INTO `area_info` VALUES ('360703', '360700', '南康区', '3');
INSERT INTO `area_info` VALUES ('360721', '360700', '赣县', '3');
INSERT INTO `area_info` VALUES ('360722', '360700', '信丰县', '3');
INSERT INTO `area_info` VALUES ('360723', '360700', '大余县', '3');
INSERT INTO `area_info` VALUES ('360724', '360700', '上犹县', '3');
INSERT INTO `area_info` VALUES ('360725', '360700', '崇义县', '3');
INSERT INTO `area_info` VALUES ('360726', '360700', '安远县', '3');
INSERT INTO `area_info` VALUES ('360727', '360700', '龙南县', '3');
INSERT INTO `area_info` VALUES ('360728', '360700', '定南县', '3');
INSERT INTO `area_info` VALUES ('360729', '360700', '全南县', '3');
INSERT INTO `area_info` VALUES ('360730', '360700', '宁都县', '3');
INSERT INTO `area_info` VALUES ('360731', '360700', '于都县', '3');
INSERT INTO `area_info` VALUES ('360732', '360700', '兴国县', '3');
INSERT INTO `area_info` VALUES ('360733', '360700', '会昌县', '3');
INSERT INTO `area_info` VALUES ('360734', '360700', '寻乌县', '3');
INSERT INTO `area_info` VALUES ('360735', '360700', '石城县', '3');
INSERT INTO `area_info` VALUES ('360781', '360700', '瑞金市', '3');
INSERT INTO `area_info` VALUES ('360800', '360000', '吉安市', '2');
INSERT INTO `area_info` VALUES ('360801', '360800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360802', '360800', '吉州区', '3');
INSERT INTO `area_info` VALUES ('360803', '360800', '青原区', '3');
INSERT INTO `area_info` VALUES ('360821', '360800', '吉安县', '3');
INSERT INTO `area_info` VALUES ('360822', '360800', '吉水县', '3');
INSERT INTO `area_info` VALUES ('360823', '360800', '峡江县', '3');
INSERT INTO `area_info` VALUES ('360824', '360800', '新干县', '3');
INSERT INTO `area_info` VALUES ('360825', '360800', '永丰县', '3');
INSERT INTO `area_info` VALUES ('360826', '360800', '泰和县', '3');
INSERT INTO `area_info` VALUES ('360827', '360800', '遂川县', '3');
INSERT INTO `area_info` VALUES ('360828', '360800', '万安县', '3');
INSERT INTO `area_info` VALUES ('360829', '360800', '安福县', '3');
INSERT INTO `area_info` VALUES ('360830', '360800', '永新县', '3');
INSERT INTO `area_info` VALUES ('360881', '360800', '井冈山市', '3');
INSERT INTO `area_info` VALUES ('360900', '360000', '宜春市', '2');
INSERT INTO `area_info` VALUES ('360901', '360900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('360902', '360900', '袁州区', '3');
INSERT INTO `area_info` VALUES ('360921', '360900', '奉新县', '3');
INSERT INTO `area_info` VALUES ('360922', '360900', '万载县', '3');
INSERT INTO `area_info` VALUES ('360923', '360900', '上高县', '3');
INSERT INTO `area_info` VALUES ('360924', '360900', '宜丰县', '3');
INSERT INTO `area_info` VALUES ('360925', '360900', '靖安县', '3');
INSERT INTO `area_info` VALUES ('360926', '360900', '铜鼓县', '3');
INSERT INTO `area_info` VALUES ('360981', '360900', '丰城市', '3');
INSERT INTO `area_info` VALUES ('360982', '360900', '樟树市', '3');
INSERT INTO `area_info` VALUES ('360983', '360900', '高安市', '3');
INSERT INTO `area_info` VALUES ('361000', '360000', '抚州市', '2');
INSERT INTO `area_info` VALUES ('361001', '361000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('361002', '361000', '临川区', '3');
INSERT INTO `area_info` VALUES ('361021', '361000', '南城县', '3');
INSERT INTO `area_info` VALUES ('361022', '361000', '黎川县', '3');
INSERT INTO `area_info` VALUES ('361023', '361000', '南丰县', '3');
INSERT INTO `area_info` VALUES ('361024', '361000', '崇仁县', '3');
INSERT INTO `area_info` VALUES ('361025', '361000', '乐安县', '3');
INSERT INTO `area_info` VALUES ('361026', '361000', '宜黄县', '3');
INSERT INTO `area_info` VALUES ('361027', '361000', '金溪县', '3');
INSERT INTO `area_info` VALUES ('361028', '361000', '资溪县', '3');
INSERT INTO `area_info` VALUES ('361029', '361000', '东乡县', '3');
INSERT INTO `area_info` VALUES ('361030', '361000', '广昌县', '3');
INSERT INTO `area_info` VALUES ('361100', '360000', '上饶市', '2');
INSERT INTO `area_info` VALUES ('361101', '361100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('361102', '361100', '信州区', '3');
INSERT INTO `area_info` VALUES ('361103', '361100', '广丰区', '3');
INSERT INTO `area_info` VALUES ('361121', '361100', '上饶县', '3');
INSERT INTO `area_info` VALUES ('361123', '361100', '玉山县', '3');
INSERT INTO `area_info` VALUES ('361124', '361100', '铅山县', '3');
INSERT INTO `area_info` VALUES ('361125', '361100', '横峰县', '3');
INSERT INTO `area_info` VALUES ('361126', '361100', '弋阳县', '3');
INSERT INTO `area_info` VALUES ('361127', '361100', '余干县', '3');
INSERT INTO `area_info` VALUES ('361128', '361100', '鄱阳县', '3');
INSERT INTO `area_info` VALUES ('361129', '361100', '万年县', '3');
INSERT INTO `area_info` VALUES ('361130', '361100', '婺源县', '3');
INSERT INTO `area_info` VALUES ('361181', '361100', '德兴市', '3');
INSERT INTO `area_info` VALUES ('370000', null, '山东省', '1');
INSERT INTO `area_info` VALUES ('370100', '370000', '济南市', '2');
INSERT INTO `area_info` VALUES ('370101', '370100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370102', '370100', '历下区', '3');
INSERT INTO `area_info` VALUES ('370103', '370100', '市中区', '3');
INSERT INTO `area_info` VALUES ('370104', '370100', '槐荫区', '3');
INSERT INTO `area_info` VALUES ('370105', '370100', '天桥区', '3');
INSERT INTO `area_info` VALUES ('370112', '370100', '历城区', '3');
INSERT INTO `area_info` VALUES ('370113', '370100', '长清区', '3');
INSERT INTO `area_info` VALUES ('370124', '370100', '平阴县', '3');
INSERT INTO `area_info` VALUES ('370125', '370100', '济阳县', '3');
INSERT INTO `area_info` VALUES ('370126', '370100', '商河县', '3');
INSERT INTO `area_info` VALUES ('370181', '370100', '章丘市', '3');
INSERT INTO `area_info` VALUES ('370200', '370000', '青岛市', '2');
INSERT INTO `area_info` VALUES ('370201', '370200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370202', '370200', '市南区', '3');
INSERT INTO `area_info` VALUES ('370203', '370200', '市北区', '3');
INSERT INTO `area_info` VALUES ('370211', '370200', '黄岛区', '3');
INSERT INTO `area_info` VALUES ('370212', '370200', '崂山区', '3');
INSERT INTO `area_info` VALUES ('370213', '370200', '李沧区', '3');
INSERT INTO `area_info` VALUES ('370214', '370200', '城阳区', '3');
INSERT INTO `area_info` VALUES ('370281', '370200', '胶州市', '3');
INSERT INTO `area_info` VALUES ('370282', '370200', '即墨市', '3');
INSERT INTO `area_info` VALUES ('370283', '370200', '平度市', '3');
INSERT INTO `area_info` VALUES ('370285', '370200', '莱西市', '3');
INSERT INTO `area_info` VALUES ('370300', '370000', '淄博市', '2');
INSERT INTO `area_info` VALUES ('370301', '370300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370302', '370300', '淄川区', '3');
INSERT INTO `area_info` VALUES ('370303', '370300', '张店区', '3');
INSERT INTO `area_info` VALUES ('370304', '370300', '博山区', '3');
INSERT INTO `area_info` VALUES ('370305', '370300', '临淄区', '3');
INSERT INTO `area_info` VALUES ('370306', '370300', '周村区', '3');
INSERT INTO `area_info` VALUES ('370321', '370300', '桓台县', '3');
INSERT INTO `area_info` VALUES ('370322', '370300', '高青县', '3');
INSERT INTO `area_info` VALUES ('370323', '370300', '沂源县', '3');
INSERT INTO `area_info` VALUES ('370400', '370000', '枣庄市', '2');
INSERT INTO `area_info` VALUES ('370401', '370400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370402', '370400', '市中区', '3');
INSERT INTO `area_info` VALUES ('370403', '370400', '薛城区', '3');
INSERT INTO `area_info` VALUES ('370404', '370400', '峄城区', '3');
INSERT INTO `area_info` VALUES ('370405', '370400', '台儿庄区', '3');
INSERT INTO `area_info` VALUES ('370406', '370400', '山亭区', '3');
INSERT INTO `area_info` VALUES ('370481', '370400', '滕州市', '3');
INSERT INTO `area_info` VALUES ('370500', '370000', '东营市', '2');
INSERT INTO `area_info` VALUES ('370501', '370500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370502', '370500', '东营区', '3');
INSERT INTO `area_info` VALUES ('370503', '370500', '河口区', '3');
INSERT INTO `area_info` VALUES ('370505', '370500', '垦利区', '3');
INSERT INTO `area_info` VALUES ('370522', '370500', '利津县', '3');
INSERT INTO `area_info` VALUES ('370523', '370500', '广饶县', '3');
INSERT INTO `area_info` VALUES ('370600', '370000', '烟台市', '2');
INSERT INTO `area_info` VALUES ('370601', '370600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370602', '370600', '芝罘区', '3');
INSERT INTO `area_info` VALUES ('370611', '370600', '福山区', '3');
INSERT INTO `area_info` VALUES ('370612', '370600', '牟平区', '3');
INSERT INTO `area_info` VALUES ('370613', '370600', '莱山区', '3');
INSERT INTO `area_info` VALUES ('370634', '370600', '长岛县', '3');
INSERT INTO `area_info` VALUES ('370681', '370600', '龙口市', '3');
INSERT INTO `area_info` VALUES ('370682', '370600', '莱阳市', '3');
INSERT INTO `area_info` VALUES ('370683', '370600', '莱州市', '3');
INSERT INTO `area_info` VALUES ('370684', '370600', '蓬莱市', '3');
INSERT INTO `area_info` VALUES ('370685', '370600', '招远市', '3');
INSERT INTO `area_info` VALUES ('370686', '370600', '栖霞市', '3');
INSERT INTO `area_info` VALUES ('370687', '370600', '海阳市', '3');
INSERT INTO `area_info` VALUES ('370700', '370000', '潍坊市', '2');
INSERT INTO `area_info` VALUES ('370701', '370700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370702', '370700', '潍城区', '3');
INSERT INTO `area_info` VALUES ('370703', '370700', '寒亭区', '3');
INSERT INTO `area_info` VALUES ('370704', '370700', '坊子区', '3');
INSERT INTO `area_info` VALUES ('370705', '370700', '奎文区', '3');
INSERT INTO `area_info` VALUES ('370724', '370700', '临朐县', '3');
INSERT INTO `area_info` VALUES ('370725', '370700', '昌乐县', '3');
INSERT INTO `area_info` VALUES ('370781', '370700', '青州市', '3');
INSERT INTO `area_info` VALUES ('370782', '370700', '诸城市', '3');
INSERT INTO `area_info` VALUES ('370783', '370700', '寿光市', '3');
INSERT INTO `area_info` VALUES ('370784', '370700', '安丘市', '3');
INSERT INTO `area_info` VALUES ('370785', '370700', '高密市', '3');
INSERT INTO `area_info` VALUES ('370786', '370700', '昌邑市', '3');
INSERT INTO `area_info` VALUES ('370800', '370000', '济宁市', '2');
INSERT INTO `area_info` VALUES ('370801', '370800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370811', '370800', '任城区', '3');
INSERT INTO `area_info` VALUES ('370812', '370800', '兖州区', '3');
INSERT INTO `area_info` VALUES ('370826', '370800', '微山县', '3');
INSERT INTO `area_info` VALUES ('370827', '370800', '鱼台县', '3');
INSERT INTO `area_info` VALUES ('370828', '370800', '金乡县', '3');
INSERT INTO `area_info` VALUES ('370829', '370800', '嘉祥县', '3');
INSERT INTO `area_info` VALUES ('370830', '370800', '汶上县', '3');
INSERT INTO `area_info` VALUES ('370831', '370800', '泗水县', '3');
INSERT INTO `area_info` VALUES ('370832', '370800', '梁山县', '3');
INSERT INTO `area_info` VALUES ('370881', '370800', '曲阜市', '3');
INSERT INTO `area_info` VALUES ('370883', '370800', '邹城市', '3');
INSERT INTO `area_info` VALUES ('370900', '370000', '泰安市', '2');
INSERT INTO `area_info` VALUES ('370901', '370900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('370902', '370900', '泰山区', '3');
INSERT INTO `area_info` VALUES ('370911', '370900', '岱岳区', '3');
INSERT INTO `area_info` VALUES ('370921', '370900', '宁阳县', '3');
INSERT INTO `area_info` VALUES ('370923', '370900', '东平县', '3');
INSERT INTO `area_info` VALUES ('370982', '370900', '新泰市', '3');
INSERT INTO `area_info` VALUES ('370983', '370900', '肥城市', '3');
INSERT INTO `area_info` VALUES ('371000', '370000', '威海市', '2');
INSERT INTO `area_info` VALUES ('371001', '371000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371002', '371000', '环翠区', '3');
INSERT INTO `area_info` VALUES ('371003', '371000', '文登区', '3');
INSERT INTO `area_info` VALUES ('371082', '371000', '荣成市', '3');
INSERT INTO `area_info` VALUES ('371083', '371000', '乳山市', '3');
INSERT INTO `area_info` VALUES ('371100', '370000', '日照市', '2');
INSERT INTO `area_info` VALUES ('371101', '371100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371102', '371100', '东港区', '3');
INSERT INTO `area_info` VALUES ('371103', '371100', '岚山区', '3');
INSERT INTO `area_info` VALUES ('371121', '371100', '五莲县', '3');
INSERT INTO `area_info` VALUES ('371122', '371100', '莒县', '3');
INSERT INTO `area_info` VALUES ('371200', '370000', '莱芜市', '2');
INSERT INTO `area_info` VALUES ('371201', '371200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371202', '371200', '莱城区', '3');
INSERT INTO `area_info` VALUES ('371203', '371200', '钢城区', '3');
INSERT INTO `area_info` VALUES ('371300', '370000', '临沂市', '2');
INSERT INTO `area_info` VALUES ('371301', '371300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371302', '371300', '兰山区', '3');
INSERT INTO `area_info` VALUES ('371311', '371300', '罗庄区', '3');
INSERT INTO `area_info` VALUES ('371312', '371300', '河东区', '3');
INSERT INTO `area_info` VALUES ('371321', '371300', '沂南县', '3');
INSERT INTO `area_info` VALUES ('371322', '371300', '郯城县', '3');
INSERT INTO `area_info` VALUES ('371323', '371300', '沂水县', '3');
INSERT INTO `area_info` VALUES ('371324', '371300', '兰陵县', '3');
INSERT INTO `area_info` VALUES ('371325', '371300', '费县', '3');
INSERT INTO `area_info` VALUES ('371326', '371300', '平邑县', '3');
INSERT INTO `area_info` VALUES ('371327', '371300', '莒南县', '3');
INSERT INTO `area_info` VALUES ('371328', '371300', '蒙阴县', '3');
INSERT INTO `area_info` VALUES ('371329', '371300', '临沭县', '3');
INSERT INTO `area_info` VALUES ('371400', '370000', '德州市', '2');
INSERT INTO `area_info` VALUES ('371401', '371400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371402', '371400', '德城区', '3');
INSERT INTO `area_info` VALUES ('371403', '371400', '陵城区', '3');
INSERT INTO `area_info` VALUES ('371422', '371400', '宁津县', '3');
INSERT INTO `area_info` VALUES ('371423', '371400', '庆云县', '3');
INSERT INTO `area_info` VALUES ('371424', '371400', '临邑县', '3');
INSERT INTO `area_info` VALUES ('371425', '371400', '齐河县', '3');
INSERT INTO `area_info` VALUES ('371426', '371400', '平原县', '3');
INSERT INTO `area_info` VALUES ('371427', '371400', '夏津县', '3');
INSERT INTO `area_info` VALUES ('371428', '371400', '武城县', '3');
INSERT INTO `area_info` VALUES ('371481', '371400', '乐陵市', '3');
INSERT INTO `area_info` VALUES ('371482', '371400', '禹城市', '3');
INSERT INTO `area_info` VALUES ('371500', '370000', '聊城市', '2');
INSERT INTO `area_info` VALUES ('371501', '371500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371502', '371500', '东昌府区', '3');
INSERT INTO `area_info` VALUES ('371521', '371500', '阳谷县', '3');
INSERT INTO `area_info` VALUES ('371522', '371500', '莘县', '3');
INSERT INTO `area_info` VALUES ('371523', '371500', '茌平县', '3');
INSERT INTO `area_info` VALUES ('371524', '371500', '东阿县', '3');
INSERT INTO `area_info` VALUES ('371525', '371500', '冠县', '3');
INSERT INTO `area_info` VALUES ('371526', '371500', '高唐县', '3');
INSERT INTO `area_info` VALUES ('371581', '371500', '临清市', '3');
INSERT INTO `area_info` VALUES ('371600', '370000', '滨州市', '2');
INSERT INTO `area_info` VALUES ('371601', '371600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371602', '371600', '滨城区', '3');
INSERT INTO `area_info` VALUES ('371603', '371600', '沾化区', '3');
INSERT INTO `area_info` VALUES ('371621', '371600', '惠民县', '3');
INSERT INTO `area_info` VALUES ('371622', '371600', '阳信县', '3');
INSERT INTO `area_info` VALUES ('371623', '371600', '无棣县', '3');
INSERT INTO `area_info` VALUES ('371625', '371600', '博兴县', '3');
INSERT INTO `area_info` VALUES ('371626', '371600', '邹平县', '3');
INSERT INTO `area_info` VALUES ('371700', '370000', '菏泽市', '2');
INSERT INTO `area_info` VALUES ('371701', '371700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('371702', '371700', '牡丹区', '3');
INSERT INTO `area_info` VALUES ('371703', '371700', '定陶区', '3');
INSERT INTO `area_info` VALUES ('371721', '371700', '曹县', '3');
INSERT INTO `area_info` VALUES ('371722', '371700', '单县', '3');
INSERT INTO `area_info` VALUES ('371723', '371700', '成武县', '3');
INSERT INTO `area_info` VALUES ('371724', '371700', '巨野县', '3');
INSERT INTO `area_info` VALUES ('371725', '371700', '郓城县', '3');
INSERT INTO `area_info` VALUES ('371726', '371700', '鄄城县', '3');
INSERT INTO `area_info` VALUES ('371728', '371700', '东明县', '3');
INSERT INTO `area_info` VALUES ('410000', null, '河南省', '1');
INSERT INTO `area_info` VALUES ('410100', '410000', '郑州市', '2');
INSERT INTO `area_info` VALUES ('410101', '410100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410102', '410100', '中原区', '3');
INSERT INTO `area_info` VALUES ('410103', '410100', '二七区', '3');
INSERT INTO `area_info` VALUES ('410104', '410100', '管城回族区', '3');
INSERT INTO `area_info` VALUES ('410105', '410100', '金水区', '3');
INSERT INTO `area_info` VALUES ('410106', '410100', '上街区', '3');
INSERT INTO `area_info` VALUES ('410108', '410100', '惠济区', '3');
INSERT INTO `area_info` VALUES ('410122', '410100', '中牟县', '3');
INSERT INTO `area_info` VALUES ('410181', '410100', '巩义市', '3');
INSERT INTO `area_info` VALUES ('410182', '410100', '荥阳市', '3');
INSERT INTO `area_info` VALUES ('410183', '410100', '新密市', '3');
INSERT INTO `area_info` VALUES ('410184', '410100', '新郑市', '3');
INSERT INTO `area_info` VALUES ('410185', '410100', '登封市', '3');
INSERT INTO `area_info` VALUES ('410200', '410000', '开封市', '2');
INSERT INTO `area_info` VALUES ('410201', '410200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410202', '410200', '龙亭区', '3');
INSERT INTO `area_info` VALUES ('410203', '410200', '顺河回族区', '3');
INSERT INTO `area_info` VALUES ('410204', '410200', '鼓楼区', '3');
INSERT INTO `area_info` VALUES ('410205', '410200', '禹王台区', '3');
INSERT INTO `area_info` VALUES ('410211', '410200', '金明区', '3');
INSERT INTO `area_info` VALUES ('410212', '410200', '祥符区', '3');
INSERT INTO `area_info` VALUES ('410221', '410200', '杞县', '3');
INSERT INTO `area_info` VALUES ('410222', '410200', '通许县', '3');
INSERT INTO `area_info` VALUES ('410223', '410200', '尉氏县', '3');
INSERT INTO `area_info` VALUES ('410225', '410200', '兰考县', '3');
INSERT INTO `area_info` VALUES ('410300', '410000', '洛阳市', '2');
INSERT INTO `area_info` VALUES ('410301', '410300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410302', '410300', '老城区', '3');
INSERT INTO `area_info` VALUES ('410303', '410300', '西工区', '3');
INSERT INTO `area_info` VALUES ('410304', '410300', '瀍河回族区', '3');
INSERT INTO `area_info` VALUES ('410305', '410300', '涧西区', '3');
INSERT INTO `area_info` VALUES ('410306', '410300', '吉利区', '3');
INSERT INTO `area_info` VALUES ('410311', '410300', '洛龙区', '3');
INSERT INTO `area_info` VALUES ('410322', '410300', '孟津县', '3');
INSERT INTO `area_info` VALUES ('410323', '410300', '新安县', '3');
INSERT INTO `area_info` VALUES ('410324', '410300', '栾川县', '3');
INSERT INTO `area_info` VALUES ('410325', '410300', '嵩县', '3');
INSERT INTO `area_info` VALUES ('410326', '410300', '汝阳县', '3');
INSERT INTO `area_info` VALUES ('410327', '410300', '宜阳县', '3');
INSERT INTO `area_info` VALUES ('410328', '410300', '洛宁县', '3');
INSERT INTO `area_info` VALUES ('410329', '410300', '伊川县', '3');
INSERT INTO `area_info` VALUES ('410381', '410300', '偃师市', '3');
INSERT INTO `area_info` VALUES ('410400', '410000', '平顶山市', '2');
INSERT INTO `area_info` VALUES ('410401', '410400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410402', '410400', '新华区', '3');
INSERT INTO `area_info` VALUES ('410403', '410400', '卫东区', '3');
INSERT INTO `area_info` VALUES ('410404', '410400', '石龙区', '3');
INSERT INTO `area_info` VALUES ('410411', '410400', '湛河区', '3');
INSERT INTO `area_info` VALUES ('410421', '410400', '宝丰县', '3');
INSERT INTO `area_info` VALUES ('410422', '410400', '叶县', '3');
INSERT INTO `area_info` VALUES ('410423', '410400', '鲁山县', '3');
INSERT INTO `area_info` VALUES ('410425', '410400', '郏县', '3');
INSERT INTO `area_info` VALUES ('410481', '410400', '舞钢市', '3');
INSERT INTO `area_info` VALUES ('410482', '410400', '汝州市', '3');
INSERT INTO `area_info` VALUES ('410500', '410000', '安阳市', '2');
INSERT INTO `area_info` VALUES ('410501', '410500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410502', '410500', '文峰区', '3');
INSERT INTO `area_info` VALUES ('410503', '410500', '北关区', '3');
INSERT INTO `area_info` VALUES ('410505', '410500', '殷都区', '3');
INSERT INTO `area_info` VALUES ('410506', '410500', '龙安区', '3');
INSERT INTO `area_info` VALUES ('410522', '410500', '安阳县', '3');
INSERT INTO `area_info` VALUES ('410523', '410500', '汤阴县', '3');
INSERT INTO `area_info` VALUES ('410526', '410500', '滑县', '3');
INSERT INTO `area_info` VALUES ('410527', '410500', '内黄县', '3');
INSERT INTO `area_info` VALUES ('410581', '410500', '林州市', '3');
INSERT INTO `area_info` VALUES ('410600', '410000', '鹤壁市', '2');
INSERT INTO `area_info` VALUES ('410601', '410600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410602', '410600', '鹤山区', '3');
INSERT INTO `area_info` VALUES ('410603', '410600', '山城区', '3');
INSERT INTO `area_info` VALUES ('410611', '410600', '淇滨区', '3');
INSERT INTO `area_info` VALUES ('410621', '410600', '浚县', '3');
INSERT INTO `area_info` VALUES ('410622', '410600', '淇县', '3');
INSERT INTO `area_info` VALUES ('410700', '410000', '新乡市', '2');
INSERT INTO `area_info` VALUES ('410701', '410700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410702', '410700', '红旗区', '3');
INSERT INTO `area_info` VALUES ('410703', '410700', '卫滨区', '3');
INSERT INTO `area_info` VALUES ('410704', '410700', '凤泉区', '3');
INSERT INTO `area_info` VALUES ('410711', '410700', '牧野区', '3');
INSERT INTO `area_info` VALUES ('410721', '410700', '新乡县', '3');
INSERT INTO `area_info` VALUES ('410724', '410700', '获嘉县', '3');
INSERT INTO `area_info` VALUES ('410725', '410700', '原阳县', '3');
INSERT INTO `area_info` VALUES ('410726', '410700', '延津县', '3');
INSERT INTO `area_info` VALUES ('410727', '410700', '封丘县', '3');
INSERT INTO `area_info` VALUES ('410728', '410700', '长垣县', '3');
INSERT INTO `area_info` VALUES ('410781', '410700', '卫辉市', '3');
INSERT INTO `area_info` VALUES ('410782', '410700', '辉县市', '3');
INSERT INTO `area_info` VALUES ('410800', '410000', '焦作市', '2');
INSERT INTO `area_info` VALUES ('410801', '410800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410802', '410800', '解放区', '3');
INSERT INTO `area_info` VALUES ('410803', '410800', '中站区', '3');
INSERT INTO `area_info` VALUES ('410804', '410800', '马村区', '3');
INSERT INTO `area_info` VALUES ('410811', '410800', '山阳区', '3');
INSERT INTO `area_info` VALUES ('410821', '410800', '修武县', '3');
INSERT INTO `area_info` VALUES ('410822', '410800', '博爱县', '3');
INSERT INTO `area_info` VALUES ('410823', '410800', '武陟县', '3');
INSERT INTO `area_info` VALUES ('410825', '410800', '温县', '3');
INSERT INTO `area_info` VALUES ('410882', '410800', '沁阳市', '3');
INSERT INTO `area_info` VALUES ('410883', '410800', '孟州市', '3');
INSERT INTO `area_info` VALUES ('410900', '410000', '濮阳市', '2');
INSERT INTO `area_info` VALUES ('410901', '410900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('410902', '410900', '华龙区', '3');
INSERT INTO `area_info` VALUES ('410922', '410900', '清丰县', '3');
INSERT INTO `area_info` VALUES ('410923', '410900', '南乐县', '3');
INSERT INTO `area_info` VALUES ('410926', '410900', '范县', '3');
INSERT INTO `area_info` VALUES ('410927', '410900', '台前县', '3');
INSERT INTO `area_info` VALUES ('410928', '410900', '濮阳县', '3');
INSERT INTO `area_info` VALUES ('411000', '410000', '许昌市', '2');
INSERT INTO `area_info` VALUES ('411001', '411000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411002', '411000', '魏都区', '3');
INSERT INTO `area_info` VALUES ('411023', '411000', '许昌县', '3');
INSERT INTO `area_info` VALUES ('411024', '411000', '鄢陵县', '3');
INSERT INTO `area_info` VALUES ('411025', '411000', '襄城县', '3');
INSERT INTO `area_info` VALUES ('411081', '411000', '禹州市', '3');
INSERT INTO `area_info` VALUES ('411082', '411000', '长葛市', '3');
INSERT INTO `area_info` VALUES ('411100', '410000', '漯河市', '2');
INSERT INTO `area_info` VALUES ('411101', '411100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411102', '411100', '源汇区', '3');
INSERT INTO `area_info` VALUES ('411103', '411100', '郾城区', '3');
INSERT INTO `area_info` VALUES ('411104', '411100', '召陵区', '3');
INSERT INTO `area_info` VALUES ('411121', '411100', '舞阳县', '3');
INSERT INTO `area_info` VALUES ('411122', '411100', '临颍县', '3');
INSERT INTO `area_info` VALUES ('411200', '410000', '三门峡市', '2');
INSERT INTO `area_info` VALUES ('411201', '411200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411202', '411200', '湖滨区', '3');
INSERT INTO `area_info` VALUES ('411203', '411200', '陕州区', '3');
INSERT INTO `area_info` VALUES ('411221', '411200', '渑池县', '3');
INSERT INTO `area_info` VALUES ('411224', '411200', '卢氏县', '3');
INSERT INTO `area_info` VALUES ('411281', '411200', '义马市', '3');
INSERT INTO `area_info` VALUES ('411282', '411200', '灵宝市', '3');
INSERT INTO `area_info` VALUES ('411300', '410000', '南阳市', '2');
INSERT INTO `area_info` VALUES ('411301', '411300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411302', '411300', '宛城区', '3');
INSERT INTO `area_info` VALUES ('411303', '411300', '卧龙区', '3');
INSERT INTO `area_info` VALUES ('411321', '411300', '南召县', '3');
INSERT INTO `area_info` VALUES ('411322', '411300', '方城县', '3');
INSERT INTO `area_info` VALUES ('411323', '411300', '西峡县', '3');
INSERT INTO `area_info` VALUES ('411324', '411300', '镇平县', '3');
INSERT INTO `area_info` VALUES ('411325', '411300', '内乡县', '3');
INSERT INTO `area_info` VALUES ('411326', '411300', '淅川县', '3');
INSERT INTO `area_info` VALUES ('411327', '411300', '社旗县', '3');
INSERT INTO `area_info` VALUES ('411328', '411300', '唐河县', '3');
INSERT INTO `area_info` VALUES ('411329', '411300', '新野县', '3');
INSERT INTO `area_info` VALUES ('411330', '411300', '桐柏县', '3');
INSERT INTO `area_info` VALUES ('411381', '411300', '邓州市', '3');
INSERT INTO `area_info` VALUES ('411400', '410000', '商丘市', '2');
INSERT INTO `area_info` VALUES ('411401', '411400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411402', '411400', '梁园区', '3');
INSERT INTO `area_info` VALUES ('411403', '411400', '睢阳区', '3');
INSERT INTO `area_info` VALUES ('411421', '411400', '民权县', '3');
INSERT INTO `area_info` VALUES ('411422', '411400', '睢县', '3');
INSERT INTO `area_info` VALUES ('411423', '411400', '宁陵县', '3');
INSERT INTO `area_info` VALUES ('411424', '411400', '柘城县', '3');
INSERT INTO `area_info` VALUES ('411425', '411400', '虞城县', '3');
INSERT INTO `area_info` VALUES ('411426', '411400', '夏邑县', '3');
INSERT INTO `area_info` VALUES ('411481', '411400', '永城市', '3');
INSERT INTO `area_info` VALUES ('411500', '410000', '信阳市', '2');
INSERT INTO `area_info` VALUES ('411501', '411500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411502', '411500', '浉河区', '3');
INSERT INTO `area_info` VALUES ('411503', '411500', '平桥区', '3');
INSERT INTO `area_info` VALUES ('411521', '411500', '罗山县', '3');
INSERT INTO `area_info` VALUES ('411522', '411500', '光山县', '3');
INSERT INTO `area_info` VALUES ('411523', '411500', '新县', '3');
INSERT INTO `area_info` VALUES ('411524', '411500', '商城县', '3');
INSERT INTO `area_info` VALUES ('411525', '411500', '固始县', '3');
INSERT INTO `area_info` VALUES ('411526', '411500', '潢川县', '3');
INSERT INTO `area_info` VALUES ('411527', '411500', '淮滨县', '3');
INSERT INTO `area_info` VALUES ('411528', '411500', '息县', '3');
INSERT INTO `area_info` VALUES ('411600', '410000', '周口市', '2');
INSERT INTO `area_info` VALUES ('411601', '411600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411602', '411600', '川汇区', '3');
INSERT INTO `area_info` VALUES ('411621', '411600', '扶沟县', '3');
INSERT INTO `area_info` VALUES ('411622', '411600', '西华县', '3');
INSERT INTO `area_info` VALUES ('411623', '411600', '商水县', '3');
INSERT INTO `area_info` VALUES ('411624', '411600', '沈丘县', '3');
INSERT INTO `area_info` VALUES ('411625', '411600', '郸城县', '3');
INSERT INTO `area_info` VALUES ('411626', '411600', '淮阳县', '3');
INSERT INTO `area_info` VALUES ('411627', '411600', '太康县', '3');
INSERT INTO `area_info` VALUES ('411628', '411600', '鹿邑县', '3');
INSERT INTO `area_info` VALUES ('411681', '411600', '项城市', '3');
INSERT INTO `area_info` VALUES ('411700', '410000', '驻马店市', '2');
INSERT INTO `area_info` VALUES ('411701', '411700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('411702', '411700', '驿城区', '3');
INSERT INTO `area_info` VALUES ('411721', '411700', '西平县', '3');
INSERT INTO `area_info` VALUES ('411722', '411700', '上蔡县', '3');
INSERT INTO `area_info` VALUES ('411723', '411700', '平舆县', '3');
INSERT INTO `area_info` VALUES ('411724', '411700', '正阳县', '3');
INSERT INTO `area_info` VALUES ('411725', '411700', '确山县', '3');
INSERT INTO `area_info` VALUES ('411726', '411700', '泌阳县', '3');
INSERT INTO `area_info` VALUES ('411727', '411700', '汝南县', '3');
INSERT INTO `area_info` VALUES ('411728', '411700', '遂平县', '3');
INSERT INTO `area_info` VALUES ('411729', '411700', '新蔡县', '3');
INSERT INTO `area_info` VALUES ('419000', '410000', '省直辖县级行政区划', '2');
INSERT INTO `area_info` VALUES ('419001', '419000', '济源市', '3');
INSERT INTO `area_info` VALUES ('420000', null, '湖北省', '1');
INSERT INTO `area_info` VALUES ('420100', '420000', '武汉市', '2');
INSERT INTO `area_info` VALUES ('420101', '420100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420102', '420100', '江岸区', '3');
INSERT INTO `area_info` VALUES ('420103', '420100', '江汉区', '3');
INSERT INTO `area_info` VALUES ('420104', '420100', '硚口区', '3');
INSERT INTO `area_info` VALUES ('420105', '420100', '汉阳区', '3');
INSERT INTO `area_info` VALUES ('420106', '420100', '武昌区', '3');
INSERT INTO `area_info` VALUES ('420107', '420100', '青山区', '3');
INSERT INTO `area_info` VALUES ('420111', '420100', '洪山区', '3');
INSERT INTO `area_info` VALUES ('420112', '420100', '东西湖区', '3');
INSERT INTO `area_info` VALUES ('420113', '420100', '汉南区', '3');
INSERT INTO `area_info` VALUES ('420114', '420100', '蔡甸区', '3');
INSERT INTO `area_info` VALUES ('420115', '420100', '江夏区', '3');
INSERT INTO `area_info` VALUES ('420116', '420100', '黄陂区', '3');
INSERT INTO `area_info` VALUES ('420117', '420100', '新洲区', '3');
INSERT INTO `area_info` VALUES ('420200', '420000', '黄石市', '2');
INSERT INTO `area_info` VALUES ('420201', '420200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420202', '420200', '黄石港区', '3');
INSERT INTO `area_info` VALUES ('420203', '420200', '西塞山区', '3');
INSERT INTO `area_info` VALUES ('420204', '420200', '下陆区', '3');
INSERT INTO `area_info` VALUES ('420205', '420200', '铁山区', '3');
INSERT INTO `area_info` VALUES ('420222', '420200', '阳新县', '3');
INSERT INTO `area_info` VALUES ('420281', '420200', '大冶市', '3');
INSERT INTO `area_info` VALUES ('420300', '420000', '十堰市', '2');
INSERT INTO `area_info` VALUES ('420301', '420300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420302', '420300', '茅箭区', '3');
INSERT INTO `area_info` VALUES ('420303', '420300', '张湾区', '3');
INSERT INTO `area_info` VALUES ('420304', '420300', '郧阳区', '3');
INSERT INTO `area_info` VALUES ('420322', '420300', '郧西县', '3');
INSERT INTO `area_info` VALUES ('420323', '420300', '竹山县', '3');
INSERT INTO `area_info` VALUES ('420324', '420300', '竹溪县', '3');
INSERT INTO `area_info` VALUES ('420325', '420300', '房县', '3');
INSERT INTO `area_info` VALUES ('420381', '420300', '丹江口市', '3');
INSERT INTO `area_info` VALUES ('420500', '420000', '宜昌市', '2');
INSERT INTO `area_info` VALUES ('420501', '420500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420502', '420500', '西陵区', '3');
INSERT INTO `area_info` VALUES ('420503', '420500', '伍家岗区', '3');
INSERT INTO `area_info` VALUES ('420504', '420500', '点军区', '3');
INSERT INTO `area_info` VALUES ('420505', '420500', '猇亭区', '3');
INSERT INTO `area_info` VALUES ('420506', '420500', '夷陵区', '3');
INSERT INTO `area_info` VALUES ('420525', '420500', '远安县', '3');
INSERT INTO `area_info` VALUES ('420526', '420500', '兴山县', '3');
INSERT INTO `area_info` VALUES ('420527', '420500', '秭归县', '3');
INSERT INTO `area_info` VALUES ('420528', '420500', '长阳土家族自治县', '3');
INSERT INTO `area_info` VALUES ('420529', '420500', '五峰土家族自治县', '3');
INSERT INTO `area_info` VALUES ('420581', '420500', '宜都市', '3');
INSERT INTO `area_info` VALUES ('420582', '420500', '当阳市', '3');
INSERT INTO `area_info` VALUES ('420583', '420500', '枝江市', '3');
INSERT INTO `area_info` VALUES ('420600', '420000', '襄阳市', '2');
INSERT INTO `area_info` VALUES ('420601', '420600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420602', '420600', '襄城区', '3');
INSERT INTO `area_info` VALUES ('420606', '420600', '樊城区', '3');
INSERT INTO `area_info` VALUES ('420607', '420600', '襄州区', '3');
INSERT INTO `area_info` VALUES ('420624', '420600', '南漳县', '3');
INSERT INTO `area_info` VALUES ('420625', '420600', '谷城县', '3');
INSERT INTO `area_info` VALUES ('420626', '420600', '保康县', '3');
INSERT INTO `area_info` VALUES ('420682', '420600', '老河口市', '3');
INSERT INTO `area_info` VALUES ('420683', '420600', '枣阳市', '3');
INSERT INTO `area_info` VALUES ('420684', '420600', '宜城市', '3');
INSERT INTO `area_info` VALUES ('420700', '420000', '鄂州市', '2');
INSERT INTO `area_info` VALUES ('420701', '420700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420702', '420700', '梁子湖区', '3');
INSERT INTO `area_info` VALUES ('420703', '420700', '华容区', '3');
INSERT INTO `area_info` VALUES ('420704', '420700', '鄂城区', '3');
INSERT INTO `area_info` VALUES ('420800', '420000', '荆门市', '2');
INSERT INTO `area_info` VALUES ('420801', '420800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420802', '420800', '东宝区', '3');
INSERT INTO `area_info` VALUES ('420804', '420800', '掇刀区', '3');
INSERT INTO `area_info` VALUES ('420821', '420800', '京山县', '3');
INSERT INTO `area_info` VALUES ('420822', '420800', '沙洋县', '3');
INSERT INTO `area_info` VALUES ('420881', '420800', '钟祥市', '3');
INSERT INTO `area_info` VALUES ('420900', '420000', '孝感市', '2');
INSERT INTO `area_info` VALUES ('420901', '420900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('420902', '420900', '孝南区', '3');
INSERT INTO `area_info` VALUES ('420921', '420900', '孝昌县', '3');
INSERT INTO `area_info` VALUES ('420922', '420900', '大悟县', '3');
INSERT INTO `area_info` VALUES ('420923', '420900', '云梦县', '3');
INSERT INTO `area_info` VALUES ('420981', '420900', '应城市', '3');
INSERT INTO `area_info` VALUES ('420982', '420900', '安陆市', '3');
INSERT INTO `area_info` VALUES ('420984', '420900', '汉川市', '3');
INSERT INTO `area_info` VALUES ('421000', '420000', '荆州市', '2');
INSERT INTO `area_info` VALUES ('421001', '421000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('421002', '421000', '沙市区', '3');
INSERT INTO `area_info` VALUES ('421003', '421000', '荆州区', '3');
INSERT INTO `area_info` VALUES ('421022', '421000', '公安县', '3');
INSERT INTO `area_info` VALUES ('421023', '421000', '监利县', '3');
INSERT INTO `area_info` VALUES ('421024', '421000', '江陵县', '3');
INSERT INTO `area_info` VALUES ('421081', '421000', '石首市', '3');
INSERT INTO `area_info` VALUES ('421083', '421000', '洪湖市', '3');
INSERT INTO `area_info` VALUES ('421087', '421000', '松滋市', '3');
INSERT INTO `area_info` VALUES ('421100', '420000', '黄冈市', '2');
INSERT INTO `area_info` VALUES ('421101', '421100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('421102', '421100', '黄州区', '3');
INSERT INTO `area_info` VALUES ('421121', '421100', '团风县', '3');
INSERT INTO `area_info` VALUES ('421122', '421100', '红安县', '3');
INSERT INTO `area_info` VALUES ('421123', '421100', '罗田县', '3');
INSERT INTO `area_info` VALUES ('421124', '421100', '英山县', '3');
INSERT INTO `area_info` VALUES ('421125', '421100', '浠水县', '3');
INSERT INTO `area_info` VALUES ('421126', '421100', '蕲春县', '3');
INSERT INTO `area_info` VALUES ('421127', '421100', '黄梅县', '3');
INSERT INTO `area_info` VALUES ('421181', '421100', '麻城市', '3');
INSERT INTO `area_info` VALUES ('421182', '421100', '武穴市', '3');
INSERT INTO `area_info` VALUES ('421200', '420000', '咸宁市', '2');
INSERT INTO `area_info` VALUES ('421201', '421200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('421202', '421200', '咸安区', '3');
INSERT INTO `area_info` VALUES ('421221', '421200', '嘉鱼县', '3');
INSERT INTO `area_info` VALUES ('421222', '421200', '通城县', '3');
INSERT INTO `area_info` VALUES ('421223', '421200', '崇阳县', '3');
INSERT INTO `area_info` VALUES ('421224', '421200', '通山县', '3');
INSERT INTO `area_info` VALUES ('421281', '421200', '赤壁市', '3');
INSERT INTO `area_info` VALUES ('421300', '420000', '随州市', '2');
INSERT INTO `area_info` VALUES ('421301', '421300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('421303', '421300', '曾都区', '3');
INSERT INTO `area_info` VALUES ('421321', '421300', '随县', '3');
INSERT INTO `area_info` VALUES ('421381', '421300', '广水市', '3');
INSERT INTO `area_info` VALUES ('422800', '420000', '恩施土家族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('422801', '422800', '恩施市', '3');
INSERT INTO `area_info` VALUES ('422802', '422800', '利川市', '3');
INSERT INTO `area_info` VALUES ('422822', '422800', '建始县', '3');
INSERT INTO `area_info` VALUES ('422823', '422800', '巴东县', '3');
INSERT INTO `area_info` VALUES ('422825', '422800', '宣恩县', '3');
INSERT INTO `area_info` VALUES ('422826', '422800', '咸丰县', '3');
INSERT INTO `area_info` VALUES ('422827', '422800', '来凤县', '3');
INSERT INTO `area_info` VALUES ('422828', '422800', '鹤峰县', '3');
INSERT INTO `area_info` VALUES ('429000', '420000', '省直辖县级行政区划', '2');
INSERT INTO `area_info` VALUES ('429004', '429000', '仙桃市', '3');
INSERT INTO `area_info` VALUES ('429005', '429000', '潜江市', '3');
INSERT INTO `area_info` VALUES ('429006', '429000', '天门市', '3');
INSERT INTO `area_info` VALUES ('429021', '429000', '神农架林区', '3');
INSERT INTO `area_info` VALUES ('430000', null, '湖南省', '1');
INSERT INTO `area_info` VALUES ('430100', '430000', '长沙市', '2');
INSERT INTO `area_info` VALUES ('430101', '430100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430102', '430100', '芙蓉区', '3');
INSERT INTO `area_info` VALUES ('430103', '430100', '天心区', '3');
INSERT INTO `area_info` VALUES ('430104', '430100', '岳麓区', '3');
INSERT INTO `area_info` VALUES ('430105', '430100', '开福区', '3');
INSERT INTO `area_info` VALUES ('430111', '430100', '雨花区', '3');
INSERT INTO `area_info` VALUES ('430112', '430100', '望城区', '3');
INSERT INTO `area_info` VALUES ('430121', '430100', '长沙县', '3');
INSERT INTO `area_info` VALUES ('430124', '430100', '宁乡县', '3');
INSERT INTO `area_info` VALUES ('430181', '430100', '浏阳市', '3');
INSERT INTO `area_info` VALUES ('430200', '430000', '株洲市', '2');
INSERT INTO `area_info` VALUES ('430201', '430200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430202', '430200', '荷塘区', '3');
INSERT INTO `area_info` VALUES ('430203', '430200', '芦淞区', '3');
INSERT INTO `area_info` VALUES ('430204', '430200', '石峰区', '3');
INSERT INTO `area_info` VALUES ('430211', '430200', '天元区', '3');
INSERT INTO `area_info` VALUES ('430221', '430200', '株洲县', '3');
INSERT INTO `area_info` VALUES ('430223', '430200', '攸县', '3');
INSERT INTO `area_info` VALUES ('430224', '430200', '茶陵县', '3');
INSERT INTO `area_info` VALUES ('430225', '430200', '炎陵县', '3');
INSERT INTO `area_info` VALUES ('430281', '430200', '醴陵市', '3');
INSERT INTO `area_info` VALUES ('430300', '430000', '湘潭市', '2');
INSERT INTO `area_info` VALUES ('430301', '430300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430302', '430300', '雨湖区', '3');
INSERT INTO `area_info` VALUES ('430304', '430300', '岳塘区', '3');
INSERT INTO `area_info` VALUES ('430321', '430300', '湘潭县', '3');
INSERT INTO `area_info` VALUES ('430381', '430300', '湘乡市', '3');
INSERT INTO `area_info` VALUES ('430382', '430300', '韶山市', '3');
INSERT INTO `area_info` VALUES ('430400', '430000', '衡阳市', '2');
INSERT INTO `area_info` VALUES ('430401', '430400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430405', '430400', '珠晖区', '3');
INSERT INTO `area_info` VALUES ('430406', '430400', '雁峰区', '3');
INSERT INTO `area_info` VALUES ('430407', '430400', '石鼓区', '3');
INSERT INTO `area_info` VALUES ('430408', '430400', '蒸湘区', '3');
INSERT INTO `area_info` VALUES ('430412', '430400', '南岳区', '3');
INSERT INTO `area_info` VALUES ('430421', '430400', '衡阳县', '3');
INSERT INTO `area_info` VALUES ('430422', '430400', '衡南县', '3');
INSERT INTO `area_info` VALUES ('430423', '430400', '衡山县', '3');
INSERT INTO `area_info` VALUES ('430424', '430400', '衡东县', '3');
INSERT INTO `area_info` VALUES ('430426', '430400', '祁东县', '3');
INSERT INTO `area_info` VALUES ('430481', '430400', '耒阳市', '3');
INSERT INTO `area_info` VALUES ('430482', '430400', '常宁市', '3');
INSERT INTO `area_info` VALUES ('430500', '430000', '邵阳市', '2');
INSERT INTO `area_info` VALUES ('430501', '430500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430502', '430500', '双清区', '3');
INSERT INTO `area_info` VALUES ('430503', '430500', '大祥区', '3');
INSERT INTO `area_info` VALUES ('430511', '430500', '北塔区', '3');
INSERT INTO `area_info` VALUES ('430521', '430500', '邵东县', '3');
INSERT INTO `area_info` VALUES ('430522', '430500', '新邵县', '3');
INSERT INTO `area_info` VALUES ('430523', '430500', '邵阳县', '3');
INSERT INTO `area_info` VALUES ('430524', '430500', '隆回县', '3');
INSERT INTO `area_info` VALUES ('430525', '430500', '洞口县', '3');
INSERT INTO `area_info` VALUES ('430527', '430500', '绥宁县', '3');
INSERT INTO `area_info` VALUES ('430528', '430500', '新宁县', '3');
INSERT INTO `area_info` VALUES ('430529', '430500', '城步苗族自治县', '3');
INSERT INTO `area_info` VALUES ('430581', '430500', '武冈市', '3');
INSERT INTO `area_info` VALUES ('430600', '430000', '岳阳市', '2');
INSERT INTO `area_info` VALUES ('430601', '430600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430602', '430600', '岳阳楼区', '3');
INSERT INTO `area_info` VALUES ('430603', '430600', '云溪区', '3');
INSERT INTO `area_info` VALUES ('430611', '430600', '君山区', '3');
INSERT INTO `area_info` VALUES ('430621', '430600', '岳阳县', '3');
INSERT INTO `area_info` VALUES ('430623', '430600', '华容县', '3');
INSERT INTO `area_info` VALUES ('430624', '430600', '湘阴县', '3');
INSERT INTO `area_info` VALUES ('430626', '430600', '平江县', '3');
INSERT INTO `area_info` VALUES ('430681', '430600', '汨罗市', '3');
INSERT INTO `area_info` VALUES ('430682', '430600', '临湘市', '3');
INSERT INTO `area_info` VALUES ('430700', '430000', '常德市', '2');
INSERT INTO `area_info` VALUES ('430701', '430700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430702', '430700', '武陵区', '3');
INSERT INTO `area_info` VALUES ('430703', '430700', '鼎城区', '3');
INSERT INTO `area_info` VALUES ('430721', '430700', '安乡县', '3');
INSERT INTO `area_info` VALUES ('430722', '430700', '汉寿县', '3');
INSERT INTO `area_info` VALUES ('430723', '430700', '澧县', '3');
INSERT INTO `area_info` VALUES ('430724', '430700', '临澧县', '3');
INSERT INTO `area_info` VALUES ('430725', '430700', '桃源县', '3');
INSERT INTO `area_info` VALUES ('430726', '430700', '石门县', '3');
INSERT INTO `area_info` VALUES ('430781', '430700', '津市市', '3');
INSERT INTO `area_info` VALUES ('430800', '430000', '张家界市', '2');
INSERT INTO `area_info` VALUES ('430801', '430800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430802', '430800', '永定区', '3');
INSERT INTO `area_info` VALUES ('430811', '430800', '武陵源区', '3');
INSERT INTO `area_info` VALUES ('430821', '430800', '慈利县', '3');
INSERT INTO `area_info` VALUES ('430822', '430800', '桑植县', '3');
INSERT INTO `area_info` VALUES ('430900', '430000', '益阳市', '2');
INSERT INTO `area_info` VALUES ('430901', '430900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('430902', '430900', '资阳区', '3');
INSERT INTO `area_info` VALUES ('430903', '430900', '赫山区', '3');
INSERT INTO `area_info` VALUES ('430921', '430900', '南县', '3');
INSERT INTO `area_info` VALUES ('430922', '430900', '桃江县', '3');
INSERT INTO `area_info` VALUES ('430923', '430900', '安化县', '3');
INSERT INTO `area_info` VALUES ('430981', '430900', '沅江市', '3');
INSERT INTO `area_info` VALUES ('431000', '430000', '郴州市', '2');
INSERT INTO `area_info` VALUES ('431001', '431000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('431002', '431000', '北湖区', '3');
INSERT INTO `area_info` VALUES ('431003', '431000', '苏仙区', '3');
INSERT INTO `area_info` VALUES ('431021', '431000', '桂阳县', '3');
INSERT INTO `area_info` VALUES ('431022', '431000', '宜章县', '3');
INSERT INTO `area_info` VALUES ('431023', '431000', '永兴县', '3');
INSERT INTO `area_info` VALUES ('431024', '431000', '嘉禾县', '3');
INSERT INTO `area_info` VALUES ('431025', '431000', '临武县', '3');
INSERT INTO `area_info` VALUES ('431026', '431000', '汝城县', '3');
INSERT INTO `area_info` VALUES ('431027', '431000', '桂东县', '3');
INSERT INTO `area_info` VALUES ('431028', '431000', '安仁县', '3');
INSERT INTO `area_info` VALUES ('431081', '431000', '资兴市', '3');
INSERT INTO `area_info` VALUES ('431100', '430000', '永州市', '2');
INSERT INTO `area_info` VALUES ('431101', '431100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('431102', '431100', '零陵区', '3');
INSERT INTO `area_info` VALUES ('431103', '431100', '冷水滩区', '3');
INSERT INTO `area_info` VALUES ('431121', '431100', '祁阳县', '3');
INSERT INTO `area_info` VALUES ('431122', '431100', '东安县', '3');
INSERT INTO `area_info` VALUES ('431123', '431100', '双牌县', '3');
INSERT INTO `area_info` VALUES ('431124', '431100', '道县', '3');
INSERT INTO `area_info` VALUES ('431125', '431100', '江永县', '3');
INSERT INTO `area_info` VALUES ('431126', '431100', '宁远县', '3');
INSERT INTO `area_info` VALUES ('431127', '431100', '蓝山县', '3');
INSERT INTO `area_info` VALUES ('431128', '431100', '新田县', '3');
INSERT INTO `area_info` VALUES ('431129', '431100', '江华瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('431200', '430000', '怀化市', '2');
INSERT INTO `area_info` VALUES ('431201', '431200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('431202', '431200', '鹤城区', '3');
INSERT INTO `area_info` VALUES ('431221', '431200', '中方县', '3');
INSERT INTO `area_info` VALUES ('431222', '431200', '沅陵县', '3');
INSERT INTO `area_info` VALUES ('431223', '431200', '辰溪县', '3');
INSERT INTO `area_info` VALUES ('431224', '431200', '溆浦县', '3');
INSERT INTO `area_info` VALUES ('431225', '431200', '会同县', '3');
INSERT INTO `area_info` VALUES ('431226', '431200', '麻阳苗族自治县', '3');
INSERT INTO `area_info` VALUES ('431227', '431200', '新晃侗族自治县', '3');
INSERT INTO `area_info` VALUES ('431228', '431200', '芷江侗族自治县', '3');
INSERT INTO `area_info` VALUES ('431229', '431200', '靖州苗族侗族自治县', '3');
INSERT INTO `area_info` VALUES ('431230', '431200', '通道侗族自治县', '3');
INSERT INTO `area_info` VALUES ('431281', '431200', '洪江市', '3');
INSERT INTO `area_info` VALUES ('431300', '430000', '娄底市', '2');
INSERT INTO `area_info` VALUES ('431301', '431300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('431302', '431300', '娄星区', '3');
INSERT INTO `area_info` VALUES ('431321', '431300', '双峰县', '3');
INSERT INTO `area_info` VALUES ('431322', '431300', '新化县', '3');
INSERT INTO `area_info` VALUES ('431381', '431300', '冷水江市', '3');
INSERT INTO `area_info` VALUES ('431382', '431300', '涟源市', '3');
INSERT INTO `area_info` VALUES ('433100', '430000', '湘西土家族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('433101', '433100', '吉首市', '3');
INSERT INTO `area_info` VALUES ('433122', '433100', '泸溪县', '3');
INSERT INTO `area_info` VALUES ('433123', '433100', '凤凰县', '3');
INSERT INTO `area_info` VALUES ('433124', '433100', '花垣县', '3');
INSERT INTO `area_info` VALUES ('433125', '433100', '保靖县', '3');
INSERT INTO `area_info` VALUES ('433126', '433100', '古丈县', '3');
INSERT INTO `area_info` VALUES ('433127', '433100', '永顺县', '3');
INSERT INTO `area_info` VALUES ('433130', '433100', '龙山县', '3');
INSERT INTO `area_info` VALUES ('440000', null, '广东省', '1');
INSERT INTO `area_info` VALUES ('440100', '440000', '广州市', '2');
INSERT INTO `area_info` VALUES ('440101', '440100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440103', '440100', '荔湾区', '3');
INSERT INTO `area_info` VALUES ('440104', '440100', '越秀区', '3');
INSERT INTO `area_info` VALUES ('440105', '440100', '海珠区', '3');
INSERT INTO `area_info` VALUES ('440106', '440100', '天河区', '3');
INSERT INTO `area_info` VALUES ('440111', '440100', '白云区', '3');
INSERT INTO `area_info` VALUES ('440112', '440100', '黄埔区', '3');
INSERT INTO `area_info` VALUES ('440113', '440100', '番禺区', '3');
INSERT INTO `area_info` VALUES ('440114', '440100', '花都区', '3');
INSERT INTO `area_info` VALUES ('440115', '440100', '南沙区', '3');
INSERT INTO `area_info` VALUES ('440117', '440100', '从化区', '3');
INSERT INTO `area_info` VALUES ('440118', '440100', '增城区', '3');
INSERT INTO `area_info` VALUES ('440200', '440000', '韶关市', '2');
INSERT INTO `area_info` VALUES ('440201', '440200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440203', '440200', '武江区', '3');
INSERT INTO `area_info` VALUES ('440204', '440200', '浈江区', '3');
INSERT INTO `area_info` VALUES ('440205', '440200', '曲江区', '3');
INSERT INTO `area_info` VALUES ('440222', '440200', '始兴县', '3');
INSERT INTO `area_info` VALUES ('440224', '440200', '仁化县', '3');
INSERT INTO `area_info` VALUES ('440229', '440200', '翁源县', '3');
INSERT INTO `area_info` VALUES ('440232', '440200', '乳源瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('440233', '440200', '新丰县', '3');
INSERT INTO `area_info` VALUES ('440281', '440200', '乐昌市', '3');
INSERT INTO `area_info` VALUES ('440282', '440200', '南雄市', '3');
INSERT INTO `area_info` VALUES ('440300', '440000', '深圳市', '2');
INSERT INTO `area_info` VALUES ('440301', '440300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440303', '440300', '罗湖区', '3');
INSERT INTO `area_info` VALUES ('440304', '440300', '福田区', '3');
INSERT INTO `area_info` VALUES ('440305', '440300', '南山区', '3');
INSERT INTO `area_info` VALUES ('440306', '440300', '宝安区', '3');
INSERT INTO `area_info` VALUES ('440307', '440300', '龙岗区', '3');
INSERT INTO `area_info` VALUES ('440308', '440300', '盐田区', '3');
INSERT INTO `area_info` VALUES ('440400', '440000', '珠海市', '2');
INSERT INTO `area_info` VALUES ('440401', '440400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440402', '440400', '香洲区', '3');
INSERT INTO `area_info` VALUES ('440403', '440400', '斗门区', '3');
INSERT INTO `area_info` VALUES ('440404', '440400', '金湾区', '3');
INSERT INTO `area_info` VALUES ('440500', '440000', '汕头市', '2');
INSERT INTO `area_info` VALUES ('440501', '440500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440507', '440500', '龙湖区', '3');
INSERT INTO `area_info` VALUES ('440511', '440500', '金平区', '3');
INSERT INTO `area_info` VALUES ('440512', '440500', '濠江区', '3');
INSERT INTO `area_info` VALUES ('440513', '440500', '潮阳区', '3');
INSERT INTO `area_info` VALUES ('440514', '440500', '潮南区', '3');
INSERT INTO `area_info` VALUES ('440515', '440500', '澄海区', '3');
INSERT INTO `area_info` VALUES ('440523', '440500', '南澳县', '3');
INSERT INTO `area_info` VALUES ('440600', '440000', '佛山市', '2');
INSERT INTO `area_info` VALUES ('440601', '440600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440604', '440600', '禅城区', '3');
INSERT INTO `area_info` VALUES ('440605', '440600', '南海区', '3');
INSERT INTO `area_info` VALUES ('440606', '440600', '顺德区', '3');
INSERT INTO `area_info` VALUES ('440607', '440600', '三水区', '3');
INSERT INTO `area_info` VALUES ('440608', '440600', '高明区', '3');
INSERT INTO `area_info` VALUES ('440700', '440000', '江门市', '2');
INSERT INTO `area_info` VALUES ('440701', '440700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440703', '440700', '蓬江区', '3');
INSERT INTO `area_info` VALUES ('440704', '440700', '江海区', '3');
INSERT INTO `area_info` VALUES ('440705', '440700', '新会区', '3');
INSERT INTO `area_info` VALUES ('440781', '440700', '台山市', '3');
INSERT INTO `area_info` VALUES ('440783', '440700', '开平市', '3');
INSERT INTO `area_info` VALUES ('440784', '440700', '鹤山市', '3');
INSERT INTO `area_info` VALUES ('440785', '440700', '恩平市', '3');
INSERT INTO `area_info` VALUES ('440800', '440000', '湛江市', '2');
INSERT INTO `area_info` VALUES ('440801', '440800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440802', '440800', '赤坎区', '3');
INSERT INTO `area_info` VALUES ('440803', '440800', '霞山区', '3');
INSERT INTO `area_info` VALUES ('440804', '440800', '坡头区', '3');
INSERT INTO `area_info` VALUES ('440811', '440800', '麻章区', '3');
INSERT INTO `area_info` VALUES ('440823', '440800', '遂溪县', '3');
INSERT INTO `area_info` VALUES ('440825', '440800', '徐闻县', '3');
INSERT INTO `area_info` VALUES ('440881', '440800', '廉江市', '3');
INSERT INTO `area_info` VALUES ('440882', '440800', '雷州市', '3');
INSERT INTO `area_info` VALUES ('440883', '440800', '吴川市', '3');
INSERT INTO `area_info` VALUES ('440900', '440000', '茂名市', '2');
INSERT INTO `area_info` VALUES ('440901', '440900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('440902', '440900', '茂南区', '3');
INSERT INTO `area_info` VALUES ('440904', '440900', '电白区', '3');
INSERT INTO `area_info` VALUES ('440981', '440900', '高州市', '3');
INSERT INTO `area_info` VALUES ('440982', '440900', '化州市', '3');
INSERT INTO `area_info` VALUES ('440983', '440900', '信宜市', '3');
INSERT INTO `area_info` VALUES ('441200', '440000', '肇庆市', '2');
INSERT INTO `area_info` VALUES ('441201', '441200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('441202', '441200', '端州区', '3');
INSERT INTO `area_info` VALUES ('441203', '441200', '鼎湖区', '3');
INSERT INTO `area_info` VALUES ('441204', '441200', '高要区', '3');
INSERT INTO `area_info` VALUES ('441223', '441200', '广宁县', '3');
INSERT INTO `area_info` VALUES ('441224', '441200', '怀集县', '3');
INSERT INTO `area_info` VALUES ('441225', '441200', '封开县', '3');
INSERT INTO `area_info` VALUES ('441226', '441200', '德庆县', '3');
INSERT INTO `area_info` VALUES ('441284', '441200', '四会市', '3');
INSERT INTO `area_info` VALUES ('441300', '440000', '惠州市', '2');
INSERT INTO `area_info` VALUES ('441301', '441300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('441302', '441300', '惠城区', '3');
INSERT INTO `area_info` VALUES ('441303', '441300', '惠阳区', '3');
INSERT INTO `area_info` VALUES ('441322', '441300', '博罗县', '3');
INSERT INTO `area_info` VALUES ('441323', '441300', '惠东县', '3');
INSERT INTO `area_info` VALUES ('441324', '441300', '龙门县', '3');
INSERT INTO `area_info` VALUES ('441400', '440000', '梅州市', '2');
INSERT INTO `area_info` VALUES ('441401', '441400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('441402', '441400', '梅江区', '3');
INSERT INTO `area_info` VALUES ('441403', '441400', '梅县区', '3');
INSERT INTO `area_info` VALUES ('441422', '441400', '大埔县', '3');
INSERT INTO `area_info` VALUES ('441423', '441400', '丰顺县', '3');
INSERT INTO `area_info` VALUES ('441424', '441400', '五华县', '3');
INSERT INTO `area_info` VALUES ('441426', '441400', '平远县', '3');
INSERT INTO `area_info` VALUES ('441427', '441400', '蕉岭县', '3');
INSERT INTO `area_info` VALUES ('441481', '441400', '兴宁市', '3');
INSERT INTO `area_info` VALUES ('441500', '440000', '汕尾市', '2');
INSERT INTO `area_info` VALUES ('441501', '441500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('441502', '441500', '城区', '3');
INSERT INTO `area_info` VALUES ('441521', '441500', '海丰县', '3');
INSERT INTO `area_info` VALUES ('441523', '441500', '陆河县', '3');
INSERT INTO `area_info` VALUES ('441581', '441500', '陆丰市', '3');
INSERT INTO `area_info` VALUES ('441600', '440000', '河源市', '2');
INSERT INTO `area_info` VALUES ('441601', '441600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('441602', '441600', '源城区', '3');
INSERT INTO `area_info` VALUES ('441621', '441600', '紫金县', '3');
INSERT INTO `area_info` VALUES ('441622', '441600', '龙川县', '3');
INSERT INTO `area_info` VALUES ('441623', '441600', '连平县', '3');
INSERT INTO `area_info` VALUES ('441624', '441600', '和平县', '3');
INSERT INTO `area_info` VALUES ('441625', '441600', '东源县', '3');
INSERT INTO `area_info` VALUES ('441700', '440000', '阳江市', '2');
INSERT INTO `area_info` VALUES ('441701', '441700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('441702', '441700', '江城区', '3');
INSERT INTO `area_info` VALUES ('441704', '441700', '阳东区', '3');
INSERT INTO `area_info` VALUES ('441721', '441700', '阳西县', '3');
INSERT INTO `area_info` VALUES ('441781', '441700', '阳春市', '3');
INSERT INTO `area_info` VALUES ('441800', '440000', '清远市', '2');
INSERT INTO `area_info` VALUES ('441801', '441800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('441802', '441800', '清城区', '3');
INSERT INTO `area_info` VALUES ('441803', '441800', '清新区', '3');
INSERT INTO `area_info` VALUES ('441821', '441800', '佛冈县', '3');
INSERT INTO `area_info` VALUES ('441823', '441800', '阳山县', '3');
INSERT INTO `area_info` VALUES ('441825', '441800', '连山壮族瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('441826', '441800', '连南瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('441881', '441800', '英德市', '3');
INSERT INTO `area_info` VALUES ('441882', '441800', '连州市', '3');
INSERT INTO `area_info` VALUES ('441900', '440000', '东莞市', '2');
INSERT INTO `area_info` VALUES ('441901', '441900', '东莞', '3');
INSERT INTO `area_info` VALUES ('442000', '440000', '中山市', '2');
INSERT INTO `area_info` VALUES ('442001', '442000', '中山', '3');
INSERT INTO `area_info` VALUES ('445100', '440000', '潮州市', '2');
INSERT INTO `area_info` VALUES ('445101', '445100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('445102', '445100', '湘桥区', '3');
INSERT INTO `area_info` VALUES ('445103', '445100', '潮安区', '3');
INSERT INTO `area_info` VALUES ('445122', '445100', '饶平县', '3');
INSERT INTO `area_info` VALUES ('445200', '440000', '揭阳市', '2');
INSERT INTO `area_info` VALUES ('445201', '445200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('445202', '445200', '榕城区', '3');
INSERT INTO `area_info` VALUES ('445203', '445200', '揭东区', '3');
INSERT INTO `area_info` VALUES ('445222', '445200', '揭西县', '3');
INSERT INTO `area_info` VALUES ('445224', '445200', '惠来县', '3');
INSERT INTO `area_info` VALUES ('445281', '445200', '普宁市', '3');
INSERT INTO `area_info` VALUES ('445300', '440000', '云浮市', '2');
INSERT INTO `area_info` VALUES ('445301', '445300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('445302', '445300', '云城区', '3');
INSERT INTO `area_info` VALUES ('445303', '445300', '云安区', '3');
INSERT INTO `area_info` VALUES ('445321', '445300', '新兴县', '3');
INSERT INTO `area_info` VALUES ('445322', '445300', '郁南县', '3');
INSERT INTO `area_info` VALUES ('445381', '445300', '罗定市', '3');
INSERT INTO `area_info` VALUES ('450000', null, '广西自治区', '1');
INSERT INTO `area_info` VALUES ('450100', '450000', '南宁市', '2');
INSERT INTO `area_info` VALUES ('450101', '450100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450200', '450000', '柳州市', '2');
INSERT INTO `area_info` VALUES ('450201', '450200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450202', '450200', '城中区', '3');
INSERT INTO `area_info` VALUES ('450203', '450200', '鱼峰区', '3');
INSERT INTO `area_info` VALUES ('450204', '450200', '柳南区', '3');
INSERT INTO `area_info` VALUES ('450205', '450200', '柳北区', '3');
INSERT INTO `area_info` VALUES ('450206', '450200', '柳江区', '3');
INSERT INTO `area_info` VALUES ('450222', '450200', '柳城县', '3');
INSERT INTO `area_info` VALUES ('450223', '450200', '鹿寨县', '3');
INSERT INTO `area_info` VALUES ('450224', '450200', '融安县', '3');
INSERT INTO `area_info` VALUES ('450225', '450200', '融水苗族自治县', '3');
INSERT INTO `area_info` VALUES ('450226', '450200', '三江侗族自治县', '3');
INSERT INTO `area_info` VALUES ('450300', '450000', '桂林市', '2');
INSERT INTO `area_info` VALUES ('450301', '450300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450302', '450300', '秀峰区', '3');
INSERT INTO `area_info` VALUES ('450303', '450300', '叠彩区', '3');
INSERT INTO `area_info` VALUES ('450304', '450300', '象山区', '3');
INSERT INTO `area_info` VALUES ('450305', '450300', '七星区', '3');
INSERT INTO `area_info` VALUES ('450311', '450300', '雁山区', '3');
INSERT INTO `area_info` VALUES ('450312', '450300', '临桂区', '3');
INSERT INTO `area_info` VALUES ('450321', '450300', '阳朔县', '3');
INSERT INTO `area_info` VALUES ('450323', '450300', '灵川县', '3');
INSERT INTO `area_info` VALUES ('450324', '450300', '全州县', '3');
INSERT INTO `area_info` VALUES ('450325', '450300', '兴安县', '3');
INSERT INTO `area_info` VALUES ('450326', '450300', '永福县', '3');
INSERT INTO `area_info` VALUES ('450327', '450300', '灌阳县', '3');
INSERT INTO `area_info` VALUES ('450328', '450300', '龙胜各族自治县', '3');
INSERT INTO `area_info` VALUES ('450329', '450300', '资源县', '3');
INSERT INTO `area_info` VALUES ('450330', '450300', '平乐县', '3');
INSERT INTO `area_info` VALUES ('450331', '450300', '荔浦县', '3');
INSERT INTO `area_info` VALUES ('450332', '450300', '恭城瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('450400', '450000', '梧州市', '2');
INSERT INTO `area_info` VALUES ('450401', '450400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450403', '450400', '万秀区', '3');
INSERT INTO `area_info` VALUES ('450405', '450400', '长洲区', '3');
INSERT INTO `area_info` VALUES ('450406', '450400', '龙圩区', '3');
INSERT INTO `area_info` VALUES ('450421', '450400', '苍梧县', '3');
INSERT INTO `area_info` VALUES ('450422', '450400', '藤县', '3');
INSERT INTO `area_info` VALUES ('450423', '450400', '蒙山县', '3');
INSERT INTO `area_info` VALUES ('450481', '450400', '岑溪市', '3');
INSERT INTO `area_info` VALUES ('450500', '450000', '北海市', '2');
INSERT INTO `area_info` VALUES ('450501', '450500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450502', '450500', '海城区', '3');
INSERT INTO `area_info` VALUES ('450503', '450500', '银海区', '3');
INSERT INTO `area_info` VALUES ('450512', '450500', '铁山港区', '3');
INSERT INTO `area_info` VALUES ('450521', '450500', '合浦县', '3');
INSERT INTO `area_info` VALUES ('450600', '450000', '防城港市', '2');
INSERT INTO `area_info` VALUES ('450601', '450600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450602', '450600', '港口区', '3');
INSERT INTO `area_info` VALUES ('450603', '450600', '防城区', '3');
INSERT INTO `area_info` VALUES ('450621', '450600', '上思县', '3');
INSERT INTO `area_info` VALUES ('450681', '450600', '东兴市', '3');
INSERT INTO `area_info` VALUES ('450700', '450000', '钦州市', '2');
INSERT INTO `area_info` VALUES ('450701', '450700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450702', '450700', '钦南区', '3');
INSERT INTO `area_info` VALUES ('450703', '450700', '钦北区', '3');
INSERT INTO `area_info` VALUES ('450721', '450700', '灵山县', '3');
INSERT INTO `area_info` VALUES ('450722', '450700', '浦北县', '3');
INSERT INTO `area_info` VALUES ('450800', '450000', '贵港市', '2');
INSERT INTO `area_info` VALUES ('450801', '450800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450802', '450800', '港北区', '3');
INSERT INTO `area_info` VALUES ('450803', '450800', '港南区', '3');
INSERT INTO `area_info` VALUES ('450804', '450800', '覃塘区', '3');
INSERT INTO `area_info` VALUES ('450821', '450800', '平南县', '3');
INSERT INTO `area_info` VALUES ('450881', '450800', '桂平市', '3');
INSERT INTO `area_info` VALUES ('450900', '450000', '玉林市', '2');
INSERT INTO `area_info` VALUES ('450901', '450900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('450902', '450900', '玉州区', '3');
INSERT INTO `area_info` VALUES ('450903', '450900', '福绵区', '3');
INSERT INTO `area_info` VALUES ('450921', '450900', '容县', '3');
INSERT INTO `area_info` VALUES ('450922', '450900', '陆川县', '3');
INSERT INTO `area_info` VALUES ('450923', '450900', '博白县', '3');
INSERT INTO `area_info` VALUES ('450924', '450900', '兴业县', '3');
INSERT INTO `area_info` VALUES ('450981', '450900', '北流市', '3');
INSERT INTO `area_info` VALUES ('451000', '450000', '百色市', '2');
INSERT INTO `area_info` VALUES ('451001', '451000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('451002', '451000', '右江区', '3');
INSERT INTO `area_info` VALUES ('451021', '451000', '田阳县', '3');
INSERT INTO `area_info` VALUES ('451022', '451000', '田东县', '3');
INSERT INTO `area_info` VALUES ('451023', '451000', '平果县', '3');
INSERT INTO `area_info` VALUES ('451024', '451000', '德保县', '3');
INSERT INTO `area_info` VALUES ('451026', '451000', '那坡县', '3');
INSERT INTO `area_info` VALUES ('451027', '451000', '凌云县', '3');
INSERT INTO `area_info` VALUES ('451028', '451000', '乐业县', '3');
INSERT INTO `area_info` VALUES ('451029', '451000', '田林县', '3');
INSERT INTO `area_info` VALUES ('451030', '451000', '西林县', '3');
INSERT INTO `area_info` VALUES ('451031', '451000', '隆林各族自治县', '3');
INSERT INTO `area_info` VALUES ('451081', '451000', '靖西市', '3');
INSERT INTO `area_info` VALUES ('451100', '450000', '贺州市', '2');
INSERT INTO `area_info` VALUES ('451101', '451100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('451102', '451100', '八步区', '3');
INSERT INTO `area_info` VALUES ('451103', '451100', '平桂区', '3');
INSERT INTO `area_info` VALUES ('451121', '451100', '昭平县', '3');
INSERT INTO `area_info` VALUES ('451122', '451100', '钟山县', '3');
INSERT INTO `area_info` VALUES ('451123', '451100', '富川瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('451200', '450000', '河池市', '2');
INSERT INTO `area_info` VALUES ('451201', '451200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('451202', '451200', '金城江区', '3');
INSERT INTO `area_info` VALUES ('451221', '451200', '南丹县', '3');
INSERT INTO `area_info` VALUES ('451222', '451200', '天峨县', '3');
INSERT INTO `area_info` VALUES ('451223', '451200', '凤山县', '3');
INSERT INTO `area_info` VALUES ('451224', '451200', '东兰县', '3');
INSERT INTO `area_info` VALUES ('451225', '451200', '罗城仫佬族自治县', '3');
INSERT INTO `area_info` VALUES ('451226', '451200', '环江毛南族自治县', '3');
INSERT INTO `area_info` VALUES ('451227', '451200', '巴马瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('451228', '451200', '都安瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('451229', '451200', '大化瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('451281', '451200', '宜州市', '3');
INSERT INTO `area_info` VALUES ('451300', '450000', '来宾市', '2');
INSERT INTO `area_info` VALUES ('451301', '451300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('451302', '451300', '兴宾区', '3');
INSERT INTO `area_info` VALUES ('451321', '451300', '忻城县', '3');
INSERT INTO `area_info` VALUES ('451322', '451300', '象州县', '3');
INSERT INTO `area_info` VALUES ('451323', '451300', '武宣县', '3');
INSERT INTO `area_info` VALUES ('451324', '451300', '金秀瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('451381', '451300', '合山市', '3');
INSERT INTO `area_info` VALUES ('451400', '450000', '崇左市', '2');
INSERT INTO `area_info` VALUES ('451401', '451400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('451402', '451400', '江州区', '3');
INSERT INTO `area_info` VALUES ('451421', '451400', '扶绥县', '3');
INSERT INTO `area_info` VALUES ('451422', '451400', '宁明县', '3');
INSERT INTO `area_info` VALUES ('451423', '451400', '龙州县', '3');
INSERT INTO `area_info` VALUES ('451424', '451400', '大新县', '3');
INSERT INTO `area_info` VALUES ('451425', '451400', '天等县', '3');
INSERT INTO `area_info` VALUES ('451481', '451400', '凭祥市', '3');
INSERT INTO `area_info` VALUES ('460000', null, '海南省', '1');
INSERT INTO `area_info` VALUES ('460100', '460000', '海口市', '2');
INSERT INTO `area_info` VALUES ('460101', '460100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('460105', '460100', '秀英区', '3');
INSERT INTO `area_info` VALUES ('460106', '460100', '龙华区', '3');
INSERT INTO `area_info` VALUES ('460107', '460100', '琼山区', '3');
INSERT INTO `area_info` VALUES ('460108', '460100', '美兰区', '3');
INSERT INTO `area_info` VALUES ('460200', '460000', '三亚市', '2');
INSERT INTO `area_info` VALUES ('460201', '460200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('460202', '460200', '海棠区', '3');
INSERT INTO `area_info` VALUES ('460203', '460200', '吉阳区', '3');
INSERT INTO `area_info` VALUES ('460204', '460200', '天涯区', '3');
INSERT INTO `area_info` VALUES ('460205', '460200', '崖州区', '3');
INSERT INTO `area_info` VALUES ('460300', '460000', '三沙市', '2');
INSERT INTO `area_info` VALUES ('460301', '460300', '三沙', '3');
INSERT INTO `area_info` VALUES ('460400', '460000', '儋州市', '2');
INSERT INTO `area_info` VALUES ('460401', '460400', '儋州', '3');
INSERT INTO `area_info` VALUES ('469000', '460000', '省直辖县级行政区划', '2');
INSERT INTO `area_info` VALUES ('469001', '469000', '五指山市', '3');
INSERT INTO `area_info` VALUES ('469002', '469000', '琼海市', '3');
INSERT INTO `area_info` VALUES ('469005', '469000', '文昌市', '3');
INSERT INTO `area_info` VALUES ('469006', '469000', '万宁市', '3');
INSERT INTO `area_info` VALUES ('469007', '469000', '东方市', '3');
INSERT INTO `area_info` VALUES ('469021', '469000', '定安县', '3');
INSERT INTO `area_info` VALUES ('469022', '469000', '屯昌县', '3');
INSERT INTO `area_info` VALUES ('469023', '469000', '澄迈县', '3');
INSERT INTO `area_info` VALUES ('469024', '469000', '临高县', '3');
INSERT INTO `area_info` VALUES ('469025', '469000', '白沙黎族自治县', '3');
INSERT INTO `area_info` VALUES ('469026', '469000', '昌江黎族自治县', '3');
INSERT INTO `area_info` VALUES ('469027', '469000', '乐东黎族自治县', '3');
INSERT INTO `area_info` VALUES ('469028', '469000', '陵水黎族自治县', '3');
INSERT INTO `area_info` VALUES ('469029', '469000', '保亭黎族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('469030', '469000', '琼中黎族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('500000', null, '重庆市', '1');
INSERT INTO `area_info` VALUES ('500100', '500000', '重庆市', '2');
INSERT INTO `area_info` VALUES ('500101', '500100', '万州区', '3');
INSERT INTO `area_info` VALUES ('500102', '500100', '涪陵区', '3');
INSERT INTO `area_info` VALUES ('500103', '500100', '渝中区', '3');
INSERT INTO `area_info` VALUES ('500104', '500100', '大渡口区', '3');
INSERT INTO `area_info` VALUES ('500105', '500100', '江北区', '3');
INSERT INTO `area_info` VALUES ('500106', '500100', '沙坪坝区', '3');
INSERT INTO `area_info` VALUES ('500107', '500100', '九龙坡区', '3');
INSERT INTO `area_info` VALUES ('500108', '500100', '南岸区', '3');
INSERT INTO `area_info` VALUES ('500109', '500100', '北碚区', '3');
INSERT INTO `area_info` VALUES ('500110', '500100', '綦江区', '3');
INSERT INTO `area_info` VALUES ('500111', '500100', '大足区', '3');
INSERT INTO `area_info` VALUES ('500112', '500100', '渝北区', '3');
INSERT INTO `area_info` VALUES ('500113', '500100', '巴南区', '3');
INSERT INTO `area_info` VALUES ('500114', '500100', '黔江区', '3');
INSERT INTO `area_info` VALUES ('500115', '500100', '长寿区', '3');
INSERT INTO `area_info` VALUES ('500116', '500100', '江津区', '3');
INSERT INTO `area_info` VALUES ('500117', '500100', '合川区', '3');
INSERT INTO `area_info` VALUES ('500118', '500100', '永川区', '3');
INSERT INTO `area_info` VALUES ('500119', '500100', '南川区', '3');
INSERT INTO `area_info` VALUES ('500120', '500100', '璧山区', '3');
INSERT INTO `area_info` VALUES ('500151', '500100', '铜梁区', '3');
INSERT INTO `area_info` VALUES ('500152', '500100', '潼南区', '3');
INSERT INTO `area_info` VALUES ('500153', '500100', '荣昌区', '3');
INSERT INTO `area_info` VALUES ('500154', '500100', '开州区', '3');
INSERT INTO `area_info` VALUES ('500200', '500000', '重庆市', '2');
INSERT INTO `area_info` VALUES ('500228', '500200', '梁平县', '3');
INSERT INTO `area_info` VALUES ('500229', '500200', '城口县', '3');
INSERT INTO `area_info` VALUES ('500230', '500200', '丰都县', '3');
INSERT INTO `area_info` VALUES ('500231', '500200', '垫江县', '3');
INSERT INTO `area_info` VALUES ('500232', '500200', '武隆县', '3');
INSERT INTO `area_info` VALUES ('500233', '500200', '忠县', '3');
INSERT INTO `area_info` VALUES ('500235', '500200', '云阳县', '3');
INSERT INTO `area_info` VALUES ('500236', '500200', '奉节县', '3');
INSERT INTO `area_info` VALUES ('500237', '500200', '巫山县', '3');
INSERT INTO `area_info` VALUES ('500238', '500200', '巫溪县', '3');
INSERT INTO `area_info` VALUES ('500240', '500200', '石柱土家族自治县', '3');
INSERT INTO `area_info` VALUES ('500241', '500200', '秀山土家族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('500242', '500200', '酉阳土家族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('500243', '500200', '彭水苗族土家族自治县', '3');
INSERT INTO `area_info` VALUES ('510000', null, '四川省', '1');
INSERT INTO `area_info` VALUES ('510100', '510000', '成都市', '2');
INSERT INTO `area_info` VALUES ('510101', '510100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510104', '510100', '锦江区', '3');
INSERT INTO `area_info` VALUES ('510105', '510100', '青羊区', '3');
INSERT INTO `area_info` VALUES ('510106', '510100', '金牛区', '3');
INSERT INTO `area_info` VALUES ('510107', '510100', '武侯区', '3');
INSERT INTO `area_info` VALUES ('510108', '510100', '成华区', '3');
INSERT INTO `area_info` VALUES ('510112', '510100', '龙泉驿区', '3');
INSERT INTO `area_info` VALUES ('510113', '510100', '青白江区', '3');
INSERT INTO `area_info` VALUES ('510114', '510100', '新都区', '3');
INSERT INTO `area_info` VALUES ('510115', '510100', '温江区', '3');
INSERT INTO `area_info` VALUES ('510116', '510100', '双流区', '3');
INSERT INTO `area_info` VALUES ('510121', '510100', '金堂县', '3');
INSERT INTO `area_info` VALUES ('510124', '510100', '郫县', '3');
INSERT INTO `area_info` VALUES ('510129', '510100', '大邑县', '3');
INSERT INTO `area_info` VALUES ('510131', '510100', '蒲江县', '3');
INSERT INTO `area_info` VALUES ('510132', '510100', '新津县', '3');
INSERT INTO `area_info` VALUES ('510181', '510100', '都江堰市', '3');
INSERT INTO `area_info` VALUES ('510182', '510100', '彭州市', '3');
INSERT INTO `area_info` VALUES ('510183', '510100', '邛崃市', '3');
INSERT INTO `area_info` VALUES ('510184', '510100', '崇州市', '3');
INSERT INTO `area_info` VALUES ('510185', '510100', '简阳市', '3');
INSERT INTO `area_info` VALUES ('510300', '510000', '自贡市', '2');
INSERT INTO `area_info` VALUES ('510301', '510300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510302', '510300', '自流井区', '3');
INSERT INTO `area_info` VALUES ('510303', '510300', '贡井区', '3');
INSERT INTO `area_info` VALUES ('510304', '510300', '大安区', '3');
INSERT INTO `area_info` VALUES ('510311', '510300', '沿滩区', '3');
INSERT INTO `area_info` VALUES ('510321', '510300', '荣县', '3');
INSERT INTO `area_info` VALUES ('510322', '510300', '富顺县', '3');
INSERT INTO `area_info` VALUES ('510400', '510000', '攀枝花市', '2');
INSERT INTO `area_info` VALUES ('510401', '510400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510402', '510400', '东区', '3');
INSERT INTO `area_info` VALUES ('510403', '510400', '西区', '3');
INSERT INTO `area_info` VALUES ('510411', '510400', '仁和区', '3');
INSERT INTO `area_info` VALUES ('510421', '510400', '米易县', '3');
INSERT INTO `area_info` VALUES ('510422', '510400', '盐边县', '3');
INSERT INTO `area_info` VALUES ('510500', '510000', '泸州市', '2');
INSERT INTO `area_info` VALUES ('510501', '510500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510502', '510500', '江阳区', '3');
INSERT INTO `area_info` VALUES ('510503', '510500', '纳溪区', '3');
INSERT INTO `area_info` VALUES ('510504', '510500', '龙马潭区', '3');
INSERT INTO `area_info` VALUES ('510521', '510500', '泸县', '3');
INSERT INTO `area_info` VALUES ('510522', '510500', '合江县', '3');
INSERT INTO `area_info` VALUES ('510524', '510500', '叙永县', '3');
INSERT INTO `area_info` VALUES ('510525', '510500', '古蔺县', '3');
INSERT INTO `area_info` VALUES ('510600', '510000', '德阳市', '2');
INSERT INTO `area_info` VALUES ('510601', '510600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510603', '510600', '旌阳区', '3');
INSERT INTO `area_info` VALUES ('510623', '510600', '中江县', '3');
INSERT INTO `area_info` VALUES ('510626', '510600', '罗江县', '3');
INSERT INTO `area_info` VALUES ('510681', '510600', '广汉市', '3');
INSERT INTO `area_info` VALUES ('510682', '510600', '什邡市', '3');
INSERT INTO `area_info` VALUES ('510683', '510600', '绵竹市', '3');
INSERT INTO `area_info` VALUES ('510700', '510000', '绵阳市', '2');
INSERT INTO `area_info` VALUES ('510701', '510700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510703', '510700', '涪城区', '3');
INSERT INTO `area_info` VALUES ('510704', '510700', '游仙区', '3');
INSERT INTO `area_info` VALUES ('510705', '510700', '安州区', '3');
INSERT INTO `area_info` VALUES ('510722', '510700', '三台县', '3');
INSERT INTO `area_info` VALUES ('510723', '510700', '盐亭县', '3');
INSERT INTO `area_info` VALUES ('510725', '510700', '梓潼县', '3');
INSERT INTO `area_info` VALUES ('510726', '510700', '北川羌族自治县', '3');
INSERT INTO `area_info` VALUES ('510727', '510700', '平武县', '3');
INSERT INTO `area_info` VALUES ('510781', '510700', '江油市', '3');
INSERT INTO `area_info` VALUES ('510800', '510000', '广元市', '2');
INSERT INTO `area_info` VALUES ('510801', '510800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510802', '510800', '利州区', '3');
INSERT INTO `area_info` VALUES ('510811', '510800', '昭化区', '3');
INSERT INTO `area_info` VALUES ('510812', '510800', '朝天区', '3');
INSERT INTO `area_info` VALUES ('510821', '510800', '旺苍县', '3');
INSERT INTO `area_info` VALUES ('510822', '510800', '青川县', '3');
INSERT INTO `area_info` VALUES ('510823', '510800', '剑阁县', '3');
INSERT INTO `area_info` VALUES ('510824', '510800', '苍溪县', '3');
INSERT INTO `area_info` VALUES ('510900', '510000', '遂宁市', '2');
INSERT INTO `area_info` VALUES ('510901', '510900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('510903', '510900', '船山区', '3');
INSERT INTO `area_info` VALUES ('510904', '510900', '安居区', '3');
INSERT INTO `area_info` VALUES ('510921', '510900', '蓬溪县', '3');
INSERT INTO `area_info` VALUES ('510922', '510900', '射洪县', '3');
INSERT INTO `area_info` VALUES ('510923', '510900', '大英县', '3');
INSERT INTO `area_info` VALUES ('511000', '510000', '内江市', '2');
INSERT INTO `area_info` VALUES ('511001', '511000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511002', '511000', '市中区', '3');
INSERT INTO `area_info` VALUES ('511011', '511000', '东兴区', '3');
INSERT INTO `area_info` VALUES ('511024', '511000', '威远县', '3');
INSERT INTO `area_info` VALUES ('511025', '511000', '资中县', '3');
INSERT INTO `area_info` VALUES ('511028', '511000', '隆昌县', '3');
INSERT INTO `area_info` VALUES ('511100', '510000', '乐山市', '2');
INSERT INTO `area_info` VALUES ('511101', '511100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511102', '511100', '市中区', '3');
INSERT INTO `area_info` VALUES ('511111', '511100', '沙湾区', '3');
INSERT INTO `area_info` VALUES ('511112', '511100', '五通桥区', '3');
INSERT INTO `area_info` VALUES ('511113', '511100', '金口河区', '3');
INSERT INTO `area_info` VALUES ('511123', '511100', '犍为县', '3');
INSERT INTO `area_info` VALUES ('511124', '511100', '井研县', '3');
INSERT INTO `area_info` VALUES ('511126', '511100', '夹江县', '3');
INSERT INTO `area_info` VALUES ('511129', '511100', '沐川县', '3');
INSERT INTO `area_info` VALUES ('511132', '511100', '峨边彝族自治县', '3');
INSERT INTO `area_info` VALUES ('511133', '511100', '马边彝族自治县', '3');
INSERT INTO `area_info` VALUES ('511181', '511100', '峨眉山市', '3');
INSERT INTO `area_info` VALUES ('511300', '510000', '南充市', '2');
INSERT INTO `area_info` VALUES ('511301', '511300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511302', '511300', '顺庆区', '3');
INSERT INTO `area_info` VALUES ('511303', '511300', '高坪区', '3');
INSERT INTO `area_info` VALUES ('511304', '511300', '嘉陵区', '3');
INSERT INTO `area_info` VALUES ('511321', '511300', '南部县', '3');
INSERT INTO `area_info` VALUES ('511322', '511300', '营山县', '3');
INSERT INTO `area_info` VALUES ('511323', '511300', '蓬安县', '3');
INSERT INTO `area_info` VALUES ('511324', '511300', '仪陇县', '3');
INSERT INTO `area_info` VALUES ('511325', '511300', '西充县', '3');
INSERT INTO `area_info` VALUES ('511381', '511300', '阆中市', '3');
INSERT INTO `area_info` VALUES ('511400', '510000', '眉山市', '2');
INSERT INTO `area_info` VALUES ('511401', '511400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511402', '511400', '东坡区', '3');
INSERT INTO `area_info` VALUES ('511403', '511400', '彭山区', '3');
INSERT INTO `area_info` VALUES ('511421', '511400', '仁寿县', '3');
INSERT INTO `area_info` VALUES ('511423', '511400', '洪雅县', '3');
INSERT INTO `area_info` VALUES ('511424', '511400', '丹棱县', '3');
INSERT INTO `area_info` VALUES ('511425', '511400', '青神县', '3');
INSERT INTO `area_info` VALUES ('511500', '510000', '宜宾市', '2');
INSERT INTO `area_info` VALUES ('511501', '511500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511502', '511500', '翠屏区', '3');
INSERT INTO `area_info` VALUES ('511503', '511500', '南溪区', '3');
INSERT INTO `area_info` VALUES ('511521', '511500', '宜宾县', '3');
INSERT INTO `area_info` VALUES ('511523', '511500', '江安县', '3');
INSERT INTO `area_info` VALUES ('511524', '511500', '长宁县', '3');
INSERT INTO `area_info` VALUES ('511525', '511500', '高县', '3');
INSERT INTO `area_info` VALUES ('511526', '511500', '珙县', '3');
INSERT INTO `area_info` VALUES ('511527', '511500', '筠连县', '3');
INSERT INTO `area_info` VALUES ('511528', '511500', '兴文县', '3');
INSERT INTO `area_info` VALUES ('511529', '511500', '屏山县', '3');
INSERT INTO `area_info` VALUES ('511600', '510000', '广安市', '2');
INSERT INTO `area_info` VALUES ('511601', '511600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511602', '511600', '广安区', '3');
INSERT INTO `area_info` VALUES ('511603', '511600', '前锋区', '3');
INSERT INTO `area_info` VALUES ('511621', '511600', '岳池县', '3');
INSERT INTO `area_info` VALUES ('511622', '511600', '武胜县', '3');
INSERT INTO `area_info` VALUES ('511623', '511600', '邻水县', '3');
INSERT INTO `area_info` VALUES ('511681', '511600', '华蓥市', '3');
INSERT INTO `area_info` VALUES ('511700', '510000', '达州市', '2');
INSERT INTO `area_info` VALUES ('511701', '511700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511702', '511700', '通川区', '3');
INSERT INTO `area_info` VALUES ('511703', '511700', '达川区', '3');
INSERT INTO `area_info` VALUES ('511722', '511700', '宣汉县', '3');
INSERT INTO `area_info` VALUES ('511723', '511700', '开江县', '3');
INSERT INTO `area_info` VALUES ('511724', '511700', '大竹县', '3');
INSERT INTO `area_info` VALUES ('511725', '511700', '渠县', '3');
INSERT INTO `area_info` VALUES ('511781', '511700', '万源市', '3');
INSERT INTO `area_info` VALUES ('511800', '510000', '雅安市', '2');
INSERT INTO `area_info` VALUES ('511801', '511800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511802', '511800', '雨城区', '3');
INSERT INTO `area_info` VALUES ('511803', '511800', '名山区', '3');
INSERT INTO `area_info` VALUES ('511822', '511800', '荥经县', '3');
INSERT INTO `area_info` VALUES ('511823', '511800', '汉源县', '3');
INSERT INTO `area_info` VALUES ('511824', '511800', '石棉县', '3');
INSERT INTO `area_info` VALUES ('511825', '511800', '天全县', '3');
INSERT INTO `area_info` VALUES ('511826', '511800', '芦山县', '3');
INSERT INTO `area_info` VALUES ('511827', '511800', '宝兴县', '3');
INSERT INTO `area_info` VALUES ('511900', '510000', '巴中市', '2');
INSERT INTO `area_info` VALUES ('511901', '511900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('511902', '511900', '巴州区', '3');
INSERT INTO `area_info` VALUES ('511903', '511900', '恩阳区', '3');
INSERT INTO `area_info` VALUES ('511921', '511900', '通江县', '3');
INSERT INTO `area_info` VALUES ('511922', '511900', '南江县', '3');
INSERT INTO `area_info` VALUES ('511923', '511900', '平昌县', '3');
INSERT INTO `area_info` VALUES ('512000', '510000', '资阳市', '2');
INSERT INTO `area_info` VALUES ('512001', '512000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('512002', '512000', '雁江区', '3');
INSERT INTO `area_info` VALUES ('512021', '512000', '安岳县', '3');
INSERT INTO `area_info` VALUES ('512022', '512000', '乐至县', '3');
INSERT INTO `area_info` VALUES ('513200', '510000', '阿坝藏族羌族自治州', '2');
INSERT INTO `area_info` VALUES ('513201', '513200', '马尔康市', '3');
INSERT INTO `area_info` VALUES ('513221', '513200', '汶川县', '3');
INSERT INTO `area_info` VALUES ('513222', '513200', '理县', '3');
INSERT INTO `area_info` VALUES ('513223', '513200', '茂县', '3');
INSERT INTO `area_info` VALUES ('513224', '513200', '松潘县', '3');
INSERT INTO `area_info` VALUES ('513225', '513200', '九寨沟县', '3');
INSERT INTO `area_info` VALUES ('513226', '513200', '金川县', '3');
INSERT INTO `area_info` VALUES ('513227', '513200', '小金县', '3');
INSERT INTO `area_info` VALUES ('513228', '513200', '黑水县', '3');
INSERT INTO `area_info` VALUES ('513230', '513200', '壤塘县', '3');
INSERT INTO `area_info` VALUES ('513231', '513200', '阿坝县', '3');
INSERT INTO `area_info` VALUES ('513232', '513200', '若尔盖县', '3');
INSERT INTO `area_info` VALUES ('513233', '513200', '红原县', '3');
INSERT INTO `area_info` VALUES ('513300', '510000', '甘孜藏族自治州', '2');
INSERT INTO `area_info` VALUES ('513301', '513300', '康定市', '3');
INSERT INTO `area_info` VALUES ('513322', '513300', '泸定县', '3');
INSERT INTO `area_info` VALUES ('513323', '513300', '丹巴县', '3');
INSERT INTO `area_info` VALUES ('513324', '513300', '九龙县', '3');
INSERT INTO `area_info` VALUES ('513325', '513300', '雅江县', '3');
INSERT INTO `area_info` VALUES ('513326', '513300', '道孚县', '3');
INSERT INTO `area_info` VALUES ('513327', '513300', '炉霍县', '3');
INSERT INTO `area_info` VALUES ('513328', '513300', '甘孜县', '3');
INSERT INTO `area_info` VALUES ('513329', '513300', '新龙县', '3');
INSERT INTO `area_info` VALUES ('513330', '513300', '德格县', '3');
INSERT INTO `area_info` VALUES ('513331', '513300', '白玉县', '3');
INSERT INTO `area_info` VALUES ('513332', '513300', '石渠县', '3');
INSERT INTO `area_info` VALUES ('513333', '513300', '色达县', '3');
INSERT INTO `area_info` VALUES ('513334', '513300', '理塘县', '3');
INSERT INTO `area_info` VALUES ('513335', '513300', '巴塘县', '3');
INSERT INTO `area_info` VALUES ('513336', '513300', '乡城县', '3');
INSERT INTO `area_info` VALUES ('513337', '513300', '稻城县', '3');
INSERT INTO `area_info` VALUES ('513338', '513300', '得荣县', '3');
INSERT INTO `area_info` VALUES ('513400', '510000', '凉山彝族自治州', '2');
INSERT INTO `area_info` VALUES ('513401', '513400', '西昌市', '3');
INSERT INTO `area_info` VALUES ('513422', '513400', '木里藏族自治县', '3');
INSERT INTO `area_info` VALUES ('513423', '513400', '盐源县', '3');
INSERT INTO `area_info` VALUES ('513424', '513400', '德昌县', '3');
INSERT INTO `area_info` VALUES ('513425', '513400', '会理县', '3');
INSERT INTO `area_info` VALUES ('513426', '513400', '会东县', '3');
INSERT INTO `area_info` VALUES ('513427', '513400', '宁南县', '3');
INSERT INTO `area_info` VALUES ('513428', '513400', '普格县', '3');
INSERT INTO `area_info` VALUES ('513429', '513400', '布拖县', '3');
INSERT INTO `area_info` VALUES ('513430', '513400', '金阳县', '3');
INSERT INTO `area_info` VALUES ('513431', '513400', '昭觉县', '3');
INSERT INTO `area_info` VALUES ('513432', '513400', '喜德县', '3');
INSERT INTO `area_info` VALUES ('513433', '513400', '冕宁县', '3');
INSERT INTO `area_info` VALUES ('513434', '513400', '越西县', '3');
INSERT INTO `area_info` VALUES ('513435', '513400', '甘洛县', '3');
INSERT INTO `area_info` VALUES ('513436', '513400', '美姑县', '3');
INSERT INTO `area_info` VALUES ('513437', '513400', '雷波县', '3');
INSERT INTO `area_info` VALUES ('520000', null, '贵州省', '1');
INSERT INTO `area_info` VALUES ('520100', '520000', '贵阳市', '2');
INSERT INTO `area_info` VALUES ('520101', '520100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('520102', '520100', '南明区', '3');
INSERT INTO `area_info` VALUES ('520103', '520100', '云岩区', '3');
INSERT INTO `area_info` VALUES ('520111', '520100', '花溪区', '3');
INSERT INTO `area_info` VALUES ('520112', '520100', '乌当区', '3');
INSERT INTO `area_info` VALUES ('520113', '520100', '白云区', '3');
INSERT INTO `area_info` VALUES ('520115', '520100', '观山湖区', '3');
INSERT INTO `area_info` VALUES ('520121', '520100', '开阳县', '3');
INSERT INTO `area_info` VALUES ('520122', '520100', '息烽县', '3');
INSERT INTO `area_info` VALUES ('520123', '520100', '修文县', '3');
INSERT INTO `area_info` VALUES ('520181', '520100', '清镇市', '3');
INSERT INTO `area_info` VALUES ('520200', '520000', '六盘水市', '2');
INSERT INTO `area_info` VALUES ('520201', '520200', '钟山区', '3');
INSERT INTO `area_info` VALUES ('520203', '520200', '六枝特区', '3');
INSERT INTO `area_info` VALUES ('520221', '520200', '水城县', '3');
INSERT INTO `area_info` VALUES ('520222', '520200', '盘县', '3');
INSERT INTO `area_info` VALUES ('520300', '520000', '遵义市', '2');
INSERT INTO `area_info` VALUES ('520301', '520300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('520302', '520300', '红花岗区', '3');
INSERT INTO `area_info` VALUES ('520303', '520300', '汇川区', '3');
INSERT INTO `area_info` VALUES ('520304', '520300', '播州区', '3');
INSERT INTO `area_info` VALUES ('520322', '520300', '桐梓县', '3');
INSERT INTO `area_info` VALUES ('520323', '520300', '绥阳县', '3');
INSERT INTO `area_info` VALUES ('520324', '520300', '正安县', '3');
INSERT INTO `area_info` VALUES ('520325', '520300', '道真仡佬族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('520326', '520300', '务川仡佬族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('520327', '520300', '凤冈县', '3');
INSERT INTO `area_info` VALUES ('520328', '520300', '湄潭县', '3');
INSERT INTO `area_info` VALUES ('520329', '520300', '余庆县', '3');
INSERT INTO `area_info` VALUES ('520330', '520300', '习水县', '3');
INSERT INTO `area_info` VALUES ('520381', '520300', '赤水市', '3');
INSERT INTO `area_info` VALUES ('520382', '520300', '仁怀市', '3');
INSERT INTO `area_info` VALUES ('520400', '520000', '安顺市', '2');
INSERT INTO `area_info` VALUES ('520401', '520400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('520402', '520400', '西秀区', '3');
INSERT INTO `area_info` VALUES ('520403', '520400', '平坝区', '3');
INSERT INTO `area_info` VALUES ('520422', '520400', '普定县', '3');
INSERT INTO `area_info` VALUES ('520423', '520400', '镇宁布依族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('520424', '520400', '关岭布依族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('520425', '520400', '紫云苗族布依族自治县', '3');
INSERT INTO `area_info` VALUES ('520500', '520000', '毕节市', '2');
INSERT INTO `area_info` VALUES ('520501', '520500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('520502', '520500', '七星关区', '3');
INSERT INTO `area_info` VALUES ('520521', '520500', '大方县', '3');
INSERT INTO `area_info` VALUES ('520522', '520500', '黔西县', '3');
INSERT INTO `area_info` VALUES ('520523', '520500', '金沙县', '3');
INSERT INTO `area_info` VALUES ('520524', '520500', '织金县', '3');
INSERT INTO `area_info` VALUES ('520525', '520500', '纳雍县', '3');
INSERT INTO `area_info` VALUES ('520526', '520500', '威宁彝族回族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('520527', '520500', '赫章县', '3');
INSERT INTO `area_info` VALUES ('520600', '520000', '铜仁市', '2');
INSERT INTO `area_info` VALUES ('520601', '520600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('520602', '520600', '碧江区', '3');
INSERT INTO `area_info` VALUES ('520603', '520600', '万山区', '3');
INSERT INTO `area_info` VALUES ('520621', '520600', '江口县', '3');
INSERT INTO `area_info` VALUES ('520622', '520600', '玉屏侗族自治县', '3');
INSERT INTO `area_info` VALUES ('520623', '520600', '石阡县', '3');
INSERT INTO `area_info` VALUES ('520624', '520600', '思南县', '3');
INSERT INTO `area_info` VALUES ('520625', '520600', '印江土家族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('520626', '520600', '德江县', '3');
INSERT INTO `area_info` VALUES ('520627', '520600', '沿河土家族自治县', '3');
INSERT INTO `area_info` VALUES ('520628', '520600', '松桃苗族自治县', '3');
INSERT INTO `area_info` VALUES ('522300', '520000', '黔西南布依族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('522301', '522300', '兴义市', '3');
INSERT INTO `area_info` VALUES ('522322', '522300', '兴仁县', '3');
INSERT INTO `area_info` VALUES ('522323', '522300', '普安县', '3');
INSERT INTO `area_info` VALUES ('522324', '522300', '晴隆县', '3');
INSERT INTO `area_info` VALUES ('522325', '522300', '贞丰县', '3');
INSERT INTO `area_info` VALUES ('522326', '522300', '望谟县', '3');
INSERT INTO `area_info` VALUES ('522327', '522300', '册亨县', '3');
INSERT INTO `area_info` VALUES ('522328', '522300', '安龙县', '3');
INSERT INTO `area_info` VALUES ('522600', '520000', '黔东南苗族侗族自治州', '2');
INSERT INTO `area_info` VALUES ('522601', '522600', '凯里市', '3');
INSERT INTO `area_info` VALUES ('522622', '522600', '黄平县', '3');
INSERT INTO `area_info` VALUES ('522623', '522600', '施秉县', '3');
INSERT INTO `area_info` VALUES ('522624', '522600', '三穗县', '3');
INSERT INTO `area_info` VALUES ('522625', '522600', '镇远县', '3');
INSERT INTO `area_info` VALUES ('522626', '522600', '岑巩县', '3');
INSERT INTO `area_info` VALUES ('522627', '522600', '天柱县', '3');
INSERT INTO `area_info` VALUES ('522628', '522600', '锦屏县', '3');
INSERT INTO `area_info` VALUES ('522629', '522600', '剑河县', '3');
INSERT INTO `area_info` VALUES ('522630', '522600', '台江县', '3');
INSERT INTO `area_info` VALUES ('522631', '522600', '黎平县', '3');
INSERT INTO `area_info` VALUES ('522632', '522600', '榕江县', '3');
INSERT INTO `area_info` VALUES ('522633', '522600', '从江县', '3');
INSERT INTO `area_info` VALUES ('522634', '522600', '雷山县', '3');
INSERT INTO `area_info` VALUES ('522635', '522600', '麻江县', '3');
INSERT INTO `area_info` VALUES ('522636', '522600', '丹寨县', '3');
INSERT INTO `area_info` VALUES ('522700', '520000', '黔南布依族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('522701', '522700', '都匀市', '3');
INSERT INTO `area_info` VALUES ('522702', '522700', '福泉市', '3');
INSERT INTO `area_info` VALUES ('522722', '522700', '荔波县', '3');
INSERT INTO `area_info` VALUES ('522723', '522700', '贵定县', '3');
INSERT INTO `area_info` VALUES ('522725', '522700', '瓮安县', '3');
INSERT INTO `area_info` VALUES ('522726', '522700', '独山县', '3');
INSERT INTO `area_info` VALUES ('522727', '522700', '平塘县', '3');
INSERT INTO `area_info` VALUES ('522728', '522700', '罗甸县', '3');
INSERT INTO `area_info` VALUES ('522729', '522700', '长顺县', '3');
INSERT INTO `area_info` VALUES ('522730', '522700', '龙里县', '3');
INSERT INTO `area_info` VALUES ('522731', '522700', '惠水县', '3');
INSERT INTO `area_info` VALUES ('522732', '522700', '三都水族自治县', '3');
INSERT INTO `area_info` VALUES ('530000', null, '云南省', '1');
INSERT INTO `area_info` VALUES ('530100', '530000', '昆明市', '2');
INSERT INTO `area_info` VALUES ('530101', '530100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530102', '530100', '五华区', '3');
INSERT INTO `area_info` VALUES ('530103', '530100', '盘龙区', '3');
INSERT INTO `area_info` VALUES ('530111', '530100', '官渡区', '3');
INSERT INTO `area_info` VALUES ('530112', '530100', '西山区', '3');
INSERT INTO `area_info` VALUES ('530113', '530100', '东川区', '3');
INSERT INTO `area_info` VALUES ('530114', '530100', '呈贡区', '3');
INSERT INTO `area_info` VALUES ('530122', '530100', '晋宁县', '3');
INSERT INTO `area_info` VALUES ('530124', '530100', '富民县', '3');
INSERT INTO `area_info` VALUES ('530125', '530100', '宜良县', '3');
INSERT INTO `area_info` VALUES ('530126', '530100', '石林彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530127', '530100', '嵩明县', '3');
INSERT INTO `area_info` VALUES ('530128', '530100', '禄劝彝族苗族自治县', '3');
INSERT INTO `area_info` VALUES ('530129', '530100', '寻甸回族彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530181', '530100', '安宁市', '3');
INSERT INTO `area_info` VALUES ('530300', '530000', '曲靖市', '2');
INSERT INTO `area_info` VALUES ('530301', '530300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530302', '530300', '麒麟区', '3');
INSERT INTO `area_info` VALUES ('530303', '530300', '沾益区', '3');
INSERT INTO `area_info` VALUES ('530321', '530300', '马龙县', '3');
INSERT INTO `area_info` VALUES ('530322', '530300', '陆良县', '3');
INSERT INTO `area_info` VALUES ('530323', '530300', '师宗县', '3');
INSERT INTO `area_info` VALUES ('530324', '530300', '罗平县', '3');
INSERT INTO `area_info` VALUES ('530325', '530300', '富源县', '3');
INSERT INTO `area_info` VALUES ('530326', '530300', '会泽县', '3');
INSERT INTO `area_info` VALUES ('530381', '530300', '宣威市', '3');
INSERT INTO `area_info` VALUES ('530400', '530000', '玉溪市', '2');
INSERT INTO `area_info` VALUES ('530401', '530400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530402', '530400', '红塔区', '3');
INSERT INTO `area_info` VALUES ('530403', '530400', '江川区', '3');
INSERT INTO `area_info` VALUES ('530422', '530400', '澄江县', '3');
INSERT INTO `area_info` VALUES ('530423', '530400', '通海县', '3');
INSERT INTO `area_info` VALUES ('530424', '530400', '华宁县', '3');
INSERT INTO `area_info` VALUES ('530425', '530400', '易门县', '3');
INSERT INTO `area_info` VALUES ('530426', '530400', '峨山彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530427', '530400', '新平彝族傣族自治县', '3');
INSERT INTO `area_info` VALUES ('530428', '530400', '元江哈尼族彝族傣族自治县', '3');
INSERT INTO `area_info` VALUES ('530500', '530000', '保山市', '2');
INSERT INTO `area_info` VALUES ('530501', '530500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530502', '530500', '隆阳区', '3');
INSERT INTO `area_info` VALUES ('530521', '530500', '施甸县', '3');
INSERT INTO `area_info` VALUES ('530523', '530500', '龙陵县', '3');
INSERT INTO `area_info` VALUES ('530524', '530500', '昌宁县', '3');
INSERT INTO `area_info` VALUES ('530581', '530500', '腾冲市', '3');
INSERT INTO `area_info` VALUES ('530600', '530000', '昭通市', '2');
INSERT INTO `area_info` VALUES ('530601', '530600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530602', '530600', '昭阳区', '3');
INSERT INTO `area_info` VALUES ('530621', '530600', '鲁甸县', '3');
INSERT INTO `area_info` VALUES ('530622', '530600', '巧家县', '3');
INSERT INTO `area_info` VALUES ('530623', '530600', '盐津县', '3');
INSERT INTO `area_info` VALUES ('530624', '530600', '大关县', '3');
INSERT INTO `area_info` VALUES ('530625', '530600', '永善县', '3');
INSERT INTO `area_info` VALUES ('530626', '530600', '绥江县', '3');
INSERT INTO `area_info` VALUES ('530627', '530600', '镇雄县', '3');
INSERT INTO `area_info` VALUES ('530628', '530600', '彝良县', '3');
INSERT INTO `area_info` VALUES ('530629', '530600', '威信县', '3');
INSERT INTO `area_info` VALUES ('530630', '530600', '水富县', '3');
INSERT INTO `area_info` VALUES ('530700', '530000', '丽江市', '2');
INSERT INTO `area_info` VALUES ('530701', '530700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530702', '530700', '古城区', '3');
INSERT INTO `area_info` VALUES ('530721', '530700', '玉龙纳西族自治县', '3');
INSERT INTO `area_info` VALUES ('530722', '530700', '永胜县', '3');
INSERT INTO `area_info` VALUES ('530723', '530700', '华坪县', '3');
INSERT INTO `area_info` VALUES ('530724', '530700', '宁蒗彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530800', '530000', '普洱市', '2');
INSERT INTO `area_info` VALUES ('530801', '530800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530802', '530800', '思茅区', '3');
INSERT INTO `area_info` VALUES ('530821', '530800', '宁洱哈尼族彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530822', '530800', '墨江哈尼族自治县', '3');
INSERT INTO `area_info` VALUES ('530823', '530800', '景东彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530824', '530800', '景谷傣族彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530825', '530800', '镇沅彝族哈尼族拉祜族自治县', '3');
INSERT INTO `area_info` VALUES ('530826', '530800', '江城哈尼族彝族自治县', '3');
INSERT INTO `area_info` VALUES ('530827', '530800', '孟连傣族拉祜族佤族自治县', '3');
INSERT INTO `area_info` VALUES ('530828', '530800', '澜沧拉祜族自治县', '3');
INSERT INTO `area_info` VALUES ('530829', '530800', '西盟佤族自治县', '3');
INSERT INTO `area_info` VALUES ('530900', '530000', '临沧市', '2');
INSERT INTO `area_info` VALUES ('530901', '530900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('530902', '530900', '临翔区', '3');
INSERT INTO `area_info` VALUES ('530921', '530900', '凤庆县', '3');
INSERT INTO `area_info` VALUES ('530922', '530900', '云县', '3');
INSERT INTO `area_info` VALUES ('530923', '530900', '永德县', '3');
INSERT INTO `area_info` VALUES ('530924', '530900', '镇康县', '3');
INSERT INTO `area_info` VALUES ('530925', '530900', '双江拉祜族佤族布朗族傣族自治县', '3');
INSERT INTO `area_info` VALUES ('530926', '530900', '耿马傣族佤族自治县', '3');
INSERT INTO `area_info` VALUES ('530927', '530900', '沧源佤族自治县', '3');
INSERT INTO `area_info` VALUES ('532300', '530000', '楚雄彝族自治州', '2');
INSERT INTO `area_info` VALUES ('532301', '532300', '楚雄市', '3');
INSERT INTO `area_info` VALUES ('532322', '532300', '双柏县', '3');
INSERT INTO `area_info` VALUES ('532323', '532300', '牟定县', '3');
INSERT INTO `area_info` VALUES ('532324', '532300', '南华县', '3');
INSERT INTO `area_info` VALUES ('532325', '532300', '姚安县', '3');
INSERT INTO `area_info` VALUES ('532326', '532300', '大姚县', '3');
INSERT INTO `area_info` VALUES ('532327', '532300', '永仁县', '3');
INSERT INTO `area_info` VALUES ('532328', '532300', '元谋县', '3');
INSERT INTO `area_info` VALUES ('532329', '532300', '武定县', '3');
INSERT INTO `area_info` VALUES ('532331', '532300', '禄丰县', '3');
INSERT INTO `area_info` VALUES ('532500', '530000', '红河哈尼族彝族自治州', '2');
INSERT INTO `area_info` VALUES ('532501', '532500', '个旧市', '3');
INSERT INTO `area_info` VALUES ('532502', '532500', '开远市', '3');
INSERT INTO `area_info` VALUES ('532503', '532500', '蒙自市', '3');
INSERT INTO `area_info` VALUES ('532504', '532500', '弥勒市', '3');
INSERT INTO `area_info` VALUES ('532523', '532500', '屏边苗族自治县', '3');
INSERT INTO `area_info` VALUES ('532524', '532500', '建水县', '3');
INSERT INTO `area_info` VALUES ('532525', '532500', '石屏县', '3');
INSERT INTO `area_info` VALUES ('532527', '532500', '泸西县', '3');
INSERT INTO `area_info` VALUES ('532528', '532500', '元阳县', '3');
INSERT INTO `area_info` VALUES ('532529', '532500', '红河县', '3');
INSERT INTO `area_info` VALUES ('532530', '532500', '金平苗族瑶族傣族自治县', '3');
INSERT INTO `area_info` VALUES ('532531', '532500', '绿春县', '3');
INSERT INTO `area_info` VALUES ('532532', '532500', '河口瑶族自治县', '3');
INSERT INTO `area_info` VALUES ('532600', '530000', '文山壮族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('532601', '532600', '文山市', '3');
INSERT INTO `area_info` VALUES ('532622', '532600', '砚山县', '3');
INSERT INTO `area_info` VALUES ('532623', '532600', '西畴县', '3');
INSERT INTO `area_info` VALUES ('532624', '532600', '麻栗坡县', '3');
INSERT INTO `area_info` VALUES ('532625', '532600', '马关县', '3');
INSERT INTO `area_info` VALUES ('532626', '532600', '丘北县', '3');
INSERT INTO `area_info` VALUES ('532627', '532600', '广南县', '3');
INSERT INTO `area_info` VALUES ('532628', '532600', '富宁县', '3');
INSERT INTO `area_info` VALUES ('532800', '530000', '西双版纳傣族自治州', '2');
INSERT INTO `area_info` VALUES ('532801', '532800', '景洪市', '3');
INSERT INTO `area_info` VALUES ('532822', '532800', '勐海县', '3');
INSERT INTO `area_info` VALUES ('532823', '532800', '勐腊县', '3');
INSERT INTO `area_info` VALUES ('532900', '530000', '大理白族自治州', '2');
INSERT INTO `area_info` VALUES ('532901', '532900', '大理市', '3');
INSERT INTO `area_info` VALUES ('532922', '532900', '漾濞彝族自治县', '3');
INSERT INTO `area_info` VALUES ('532923', '532900', '祥云县', '3');
INSERT INTO `area_info` VALUES ('532924', '532900', '宾川县', '3');
INSERT INTO `area_info` VALUES ('532925', '532900', '弥渡县', '3');
INSERT INTO `area_info` VALUES ('532926', '532900', '南涧彝族自治县', '3');
INSERT INTO `area_info` VALUES ('532927', '532900', '巍山彝族回族自治县', '3');
INSERT INTO `area_info` VALUES ('532928', '532900', '永平县', '3');
INSERT INTO `area_info` VALUES ('532929', '532900', '云龙县', '3');
INSERT INTO `area_info` VALUES ('532930', '532900', '洱源县', '3');
INSERT INTO `area_info` VALUES ('532931', '532900', '剑川县', '3');
INSERT INTO `area_info` VALUES ('532932', '532900', '鹤庆县', '3');
INSERT INTO `area_info` VALUES ('533100', '530000', '德宏傣族景颇族自治州', '2');
INSERT INTO `area_info` VALUES ('533102', '533100', '瑞丽市', '3');
INSERT INTO `area_info` VALUES ('533103', '533100', '芒市', '3');
INSERT INTO `area_info` VALUES ('533122', '533100', '梁河县', '3');
INSERT INTO `area_info` VALUES ('533123', '533100', '盈江县', '3');
INSERT INTO `area_info` VALUES ('533124', '533100', '陇川县', '3');
INSERT INTO `area_info` VALUES ('533300', '530000', '怒江傈僳族自治州', '2');
INSERT INTO `area_info` VALUES ('533301', '533300', '泸水市', '3');
INSERT INTO `area_info` VALUES ('533323', '533300', '福贡县', '3');
INSERT INTO `area_info` VALUES ('533324', '533300', '贡山独龙族怒族自治县', '3');
INSERT INTO `area_info` VALUES ('533325', '533300', '兰坪白族普米族自治县', '3');
INSERT INTO `area_info` VALUES ('533400', '530000', '迪庆藏族自治州', '2');
INSERT INTO `area_info` VALUES ('533401', '533400', '香格里拉市', '3');
INSERT INTO `area_info` VALUES ('533422', '533400', '德钦县', '3');
INSERT INTO `area_info` VALUES ('533423', '533400', '维西傈僳族自治县', '3');
INSERT INTO `area_info` VALUES ('540000', null, '西藏自治区', '1');
INSERT INTO `area_info` VALUES ('540100', '540000', '拉萨市', '2');
INSERT INTO `area_info` VALUES ('540101', '540100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('540102', '540100', '城关区', '3');
INSERT INTO `area_info` VALUES ('540103', '540100', '堆龙德庆区', '3');
INSERT INTO `area_info` VALUES ('540121', '540100', '林周县', '3');
INSERT INTO `area_info` VALUES ('540122', '540100', '当雄县', '3');
INSERT INTO `area_info` VALUES ('540123', '540100', '尼木县', '3');
INSERT INTO `area_info` VALUES ('540124', '540100', '曲水县', '3');
INSERT INTO `area_info` VALUES ('540126', '540100', '达孜县', '3');
INSERT INTO `area_info` VALUES ('540127', '540100', '墨竹工卡县', '3');
INSERT INTO `area_info` VALUES ('540200', '540000', '日喀则市', '2');
INSERT INTO `area_info` VALUES ('540202', '540200', '桑珠孜区', '3');
INSERT INTO `area_info` VALUES ('540221', '540200', '南木林县', '3');
INSERT INTO `area_info` VALUES ('540222', '540200', '江孜县', '3');
INSERT INTO `area_info` VALUES ('540223', '540200', '定日县', '3');
INSERT INTO `area_info` VALUES ('540224', '540200', '萨迦县', '3');
INSERT INTO `area_info` VALUES ('540225', '540200', '拉孜县', '3');
INSERT INTO `area_info` VALUES ('540226', '540200', '昂仁县', '3');
INSERT INTO `area_info` VALUES ('540227', '540200', '谢通门县', '3');
INSERT INTO `area_info` VALUES ('540228', '540200', '白朗县', '3');
INSERT INTO `area_info` VALUES ('540229', '540200', '仁布县', '3');
INSERT INTO `area_info` VALUES ('540230', '540200', '康马县', '3');
INSERT INTO `area_info` VALUES ('540231', '540200', '定结县', '3');
INSERT INTO `area_info` VALUES ('540232', '540200', '仲巴县', '3');
INSERT INTO `area_info` VALUES ('540233', '540200', '亚东县', '3');
INSERT INTO `area_info` VALUES ('540234', '540200', '吉隆县', '3');
INSERT INTO `area_info` VALUES ('540235', '540200', '聂拉木县', '3');
INSERT INTO `area_info` VALUES ('540236', '540200', '萨嘎县', '3');
INSERT INTO `area_info` VALUES ('540237', '540200', '岗巴县', '3');
INSERT INTO `area_info` VALUES ('540300', '540000', '昌都市', '2');
INSERT INTO `area_info` VALUES ('540302', '540300', '卡若区', '3');
INSERT INTO `area_info` VALUES ('540321', '540300', '江达县', '3');
INSERT INTO `area_info` VALUES ('540322', '540300', '贡觉县', '3');
INSERT INTO `area_info` VALUES ('540323', '540300', '类乌齐县', '3');
INSERT INTO `area_info` VALUES ('540324', '540300', '丁青县', '3');
INSERT INTO `area_info` VALUES ('540325', '540300', '察雅县', '3');
INSERT INTO `area_info` VALUES ('540326', '540300', '八宿县', '3');
INSERT INTO `area_info` VALUES ('540327', '540300', '左贡县', '3');
INSERT INTO `area_info` VALUES ('540328', '540300', '芒康县', '3');
INSERT INTO `area_info` VALUES ('540329', '540300', '洛隆县', '3');
INSERT INTO `area_info` VALUES ('540330', '540300', '边坝县', '3');
INSERT INTO `area_info` VALUES ('540400', '540000', '林芝市', '2');
INSERT INTO `area_info` VALUES ('540402', '540400', '巴宜区', '3');
INSERT INTO `area_info` VALUES ('540421', '540400', '工布江达县', '3');
INSERT INTO `area_info` VALUES ('540422', '540400', '米林县', '3');
INSERT INTO `area_info` VALUES ('540423', '540400', '墨脱县', '3');
INSERT INTO `area_info` VALUES ('540424', '540400', '波密县', '3');
INSERT INTO `area_info` VALUES ('540425', '540400', '察隅县', '3');
INSERT INTO `area_info` VALUES ('540426', '540400', '朗县', '3');
INSERT INTO `area_info` VALUES ('540500', '540000', '山南市', '2');
INSERT INTO `area_info` VALUES ('540501', '540500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('540502', '540500', '乃东区', '3');
INSERT INTO `area_info` VALUES ('540521', '540500', '扎囊县', '3');
INSERT INTO `area_info` VALUES ('540522', '540500', '贡嘎县', '3');
INSERT INTO `area_info` VALUES ('540523', '540500', '桑日县', '3');
INSERT INTO `area_info` VALUES ('540524', '540500', '琼结县', '3');
INSERT INTO `area_info` VALUES ('540525', '540500', '曲松县', '3');
INSERT INTO `area_info` VALUES ('540526', '540500', '措美县', '3');
INSERT INTO `area_info` VALUES ('540527', '540500', '洛扎县', '3');
INSERT INTO `area_info` VALUES ('540528', '540500', '加查县', '3');
INSERT INTO `area_info` VALUES ('540529', '540500', '隆子县', '3');
INSERT INTO `area_info` VALUES ('540530', '540500', '错那县', '3');
INSERT INTO `area_info` VALUES ('540531', '540500', '浪卡子县', '3');
INSERT INTO `area_info` VALUES ('542400', '540000', '那曲地区', '2');
INSERT INTO `area_info` VALUES ('542421', '542400', '那曲县', '3');
INSERT INTO `area_info` VALUES ('542422', '542400', '嘉黎县', '3');
INSERT INTO `area_info` VALUES ('542423', '542400', '比如县', '3');
INSERT INTO `area_info` VALUES ('542424', '542400', '聂荣县', '3');
INSERT INTO `area_info` VALUES ('542425', '542400', '安多县', '3');
INSERT INTO `area_info` VALUES ('542426', '542400', '申扎县', '3');
INSERT INTO `area_info` VALUES ('542427', '542400', '索县', '3');
INSERT INTO `area_info` VALUES ('542428', '542400', '班戈县', '3');
INSERT INTO `area_info` VALUES ('542429', '542400', '巴青县', '3');
INSERT INTO `area_info` VALUES ('542430', '542400', '尼玛县', '3');
INSERT INTO `area_info` VALUES ('542431', '542400', '双湖县', '3');
INSERT INTO `area_info` VALUES ('542500', '540000', '阿里地区', '2');
INSERT INTO `area_info` VALUES ('542521', '542500', '普兰县', '3');
INSERT INTO `area_info` VALUES ('542522', '542500', '札达县', '3');
INSERT INTO `area_info` VALUES ('542523', '542500', '噶尔县', '3');
INSERT INTO `area_info` VALUES ('542524', '542500', '日土县', '3');
INSERT INTO `area_info` VALUES ('542525', '542500', '革吉县', '3');
INSERT INTO `area_info` VALUES ('542526', '542500', '改则县', '3');
INSERT INTO `area_info` VALUES ('542527', '542500', '措勤县', '3');
INSERT INTO `area_info` VALUES ('610000', null, '陕西省', '1');
INSERT INTO `area_info` VALUES ('610100', '610000', '西安市', '2');
INSERT INTO `area_info` VALUES ('610101', '610100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610102', '610100', '新城区', '3');
INSERT INTO `area_info` VALUES ('610103', '610100', '碑林区', '3');
INSERT INTO `area_info` VALUES ('610104', '610100', '莲湖区', '3');
INSERT INTO `area_info` VALUES ('610111', '610100', '灞桥区', '3');
INSERT INTO `area_info` VALUES ('610112', '610100', '未央区', '3');
INSERT INTO `area_info` VALUES ('610113', '610100', '雁塔区', '3');
INSERT INTO `area_info` VALUES ('610114', '610100', '阎良区', '3');
INSERT INTO `area_info` VALUES ('610115', '610100', '临潼区', '3');
INSERT INTO `area_info` VALUES ('610116', '610100', '长安区', '3');
INSERT INTO `area_info` VALUES ('610117', '610100', '高陵区', '3');
INSERT INTO `area_info` VALUES ('610122', '610100', '蓝田县', '3');
INSERT INTO `area_info` VALUES ('610124', '610100', '周至县', '3');
INSERT INTO `area_info` VALUES ('610125', '610100', '户县', '3');
INSERT INTO `area_info` VALUES ('610200', '610000', '铜川市', '2');
INSERT INTO `area_info` VALUES ('610201', '610200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610202', '610200', '王益区', '3');
INSERT INTO `area_info` VALUES ('610203', '610200', '印台区', '3');
INSERT INTO `area_info` VALUES ('610204', '610200', '耀州区', '3');
INSERT INTO `area_info` VALUES ('610222', '610200', '宜君县', '3');
INSERT INTO `area_info` VALUES ('610300', '610000', '宝鸡市', '2');
INSERT INTO `area_info` VALUES ('610301', '610300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610302', '610300', '渭滨区', '3');
INSERT INTO `area_info` VALUES ('610303', '610300', '金台区', '3');
INSERT INTO `area_info` VALUES ('610304', '610300', '陈仓区', '3');
INSERT INTO `area_info` VALUES ('610322', '610300', '凤翔县', '3');
INSERT INTO `area_info` VALUES ('610323', '610300', '岐山县', '3');
INSERT INTO `area_info` VALUES ('610324', '610300', '扶风县', '3');
INSERT INTO `area_info` VALUES ('610326', '610300', '眉县', '3');
INSERT INTO `area_info` VALUES ('610327', '610300', '陇县', '3');
INSERT INTO `area_info` VALUES ('610328', '610300', '千阳县', '3');
INSERT INTO `area_info` VALUES ('610329', '610300', '麟游县', '3');
INSERT INTO `area_info` VALUES ('610330', '610300', '凤县', '3');
INSERT INTO `area_info` VALUES ('610331', '610300', '太白县', '3');
INSERT INTO `area_info` VALUES ('610400', '610000', '咸阳市', '2');
INSERT INTO `area_info` VALUES ('610401', '610400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610402', '610400', '秦都区', '3');
INSERT INTO `area_info` VALUES ('610403', '610400', '杨陵区', '3');
INSERT INTO `area_info` VALUES ('610404', '610400', '渭城区', '3');
INSERT INTO `area_info` VALUES ('610422', '610400', '三原县', '3');
INSERT INTO `area_info` VALUES ('610423', '610400', '泾阳县', '3');
INSERT INTO `area_info` VALUES ('610424', '610400', '乾县', '3');
INSERT INTO `area_info` VALUES ('610425', '610400', '礼泉县', '3');
INSERT INTO `area_info` VALUES ('610426', '610400', '永寿县', '3');
INSERT INTO `area_info` VALUES ('610427', '610400', '彬县', '3');
INSERT INTO `area_info` VALUES ('610428', '610400', '长武县', '3');
INSERT INTO `area_info` VALUES ('610429', '610400', '旬邑县', '3');
INSERT INTO `area_info` VALUES ('610430', '610400', '淳化县', '3');
INSERT INTO `area_info` VALUES ('610431', '610400', '武功县', '3');
INSERT INTO `area_info` VALUES ('610481', '610400', '兴平市', '3');
INSERT INTO `area_info` VALUES ('610500', '610000', '渭南市', '2');
INSERT INTO `area_info` VALUES ('610501', '610500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610502', '610500', '临渭区', '3');
INSERT INTO `area_info` VALUES ('610503', '610500', '华州区', '3');
INSERT INTO `area_info` VALUES ('610522', '610500', '潼关县', '3');
INSERT INTO `area_info` VALUES ('610523', '610500', '大荔县', '3');
INSERT INTO `area_info` VALUES ('610524', '610500', '合阳县', '3');
INSERT INTO `area_info` VALUES ('610525', '610500', '澄城县', '3');
INSERT INTO `area_info` VALUES ('610526', '610500', '蒲城县', '3');
INSERT INTO `area_info` VALUES ('610527', '610500', '白水县', '3');
INSERT INTO `area_info` VALUES ('610528', '610500', '富平县', '3');
INSERT INTO `area_info` VALUES ('610581', '610500', '韩城市', '3');
INSERT INTO `area_info` VALUES ('610582', '610500', '华阴市', '3');
INSERT INTO `area_info` VALUES ('610600', '610000', '延安市', '2');
INSERT INTO `area_info` VALUES ('610601', '610600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610602', '610600', '宝塔区', '3');
INSERT INTO `area_info` VALUES ('610603', '610600', '安塞区', '3');
INSERT INTO `area_info` VALUES ('610621', '610600', '延长县', '3');
INSERT INTO `area_info` VALUES ('610622', '610600', '延川县', '3');
INSERT INTO `area_info` VALUES ('610623', '610600', '子长县', '3');
INSERT INTO `area_info` VALUES ('610625', '610600', '志丹县', '3');
INSERT INTO `area_info` VALUES ('610626', '610600', '吴起县', '3');
INSERT INTO `area_info` VALUES ('610627', '610600', '甘泉县', '3');
INSERT INTO `area_info` VALUES ('610628', '610600', '富县', '3');
INSERT INTO `area_info` VALUES ('610629', '610600', '洛川县', '3');
INSERT INTO `area_info` VALUES ('610630', '610600', '宜川县', '3');
INSERT INTO `area_info` VALUES ('610631', '610600', '黄龙县', '3');
INSERT INTO `area_info` VALUES ('610632', '610600', '黄陵县', '3');
INSERT INTO `area_info` VALUES ('610700', '610000', '汉中市', '2');
INSERT INTO `area_info` VALUES ('610701', '610700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610702', '610700', '汉台区', '3');
INSERT INTO `area_info` VALUES ('610721', '610700', '南郑县', '3');
INSERT INTO `area_info` VALUES ('610722', '610700', '城固县', '3');
INSERT INTO `area_info` VALUES ('610723', '610700', '洋县', '3');
INSERT INTO `area_info` VALUES ('610724', '610700', '西乡县', '3');
INSERT INTO `area_info` VALUES ('610725', '610700', '勉县', '3');
INSERT INTO `area_info` VALUES ('610726', '610700', '宁强县', '3');
INSERT INTO `area_info` VALUES ('610727', '610700', '略阳县', '3');
INSERT INTO `area_info` VALUES ('610728', '610700', '镇巴县', '3');
INSERT INTO `area_info` VALUES ('610729', '610700', '留坝县', '3');
INSERT INTO `area_info` VALUES ('610730', '610700', '佛坪县', '3');
INSERT INTO `area_info` VALUES ('610800', '610000', '榆林市', '2');
INSERT INTO `area_info` VALUES ('610801', '610800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610802', '610800', '榆阳区', '3');
INSERT INTO `area_info` VALUES ('610803', '610800', '横山区', '3');
INSERT INTO `area_info` VALUES ('610821', '610800', '神木县', '3');
INSERT INTO `area_info` VALUES ('610822', '610800', '府谷县', '3');
INSERT INTO `area_info` VALUES ('610824', '610800', '靖边县', '3');
INSERT INTO `area_info` VALUES ('610825', '610800', '定边县', '3');
INSERT INTO `area_info` VALUES ('610826', '610800', '绥德县', '3');
INSERT INTO `area_info` VALUES ('610827', '610800', '米脂县', '3');
INSERT INTO `area_info` VALUES ('610828', '610800', '佳县', '3');
INSERT INTO `area_info` VALUES ('610829', '610800', '吴堡县', '3');
INSERT INTO `area_info` VALUES ('610830', '610800', '清涧县', '3');
INSERT INTO `area_info` VALUES ('610831', '610800', '子洲县', '3');
INSERT INTO `area_info` VALUES ('610900', '610000', '安康市', '2');
INSERT INTO `area_info` VALUES ('610901', '610900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('610902', '610900', '汉滨区', '3');
INSERT INTO `area_info` VALUES ('610921', '610900', '汉阴县', '3');
INSERT INTO `area_info` VALUES ('610922', '610900', '石泉县', '3');
INSERT INTO `area_info` VALUES ('610923', '610900', '宁陕县', '3');
INSERT INTO `area_info` VALUES ('610924', '610900', '紫阳县', '3');
INSERT INTO `area_info` VALUES ('610925', '610900', '岚皋县', '3');
INSERT INTO `area_info` VALUES ('610926', '610900', '平利县', '3');
INSERT INTO `area_info` VALUES ('610927', '610900', '镇坪县', '3');
INSERT INTO `area_info` VALUES ('610928', '610900', '旬阳县', '3');
INSERT INTO `area_info` VALUES ('610929', '610900', '白河县', '3');
INSERT INTO `area_info` VALUES ('611000', '610000', '商洛市', '2');
INSERT INTO `area_info` VALUES ('611001', '611000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('611002', '611000', '商州区', '3');
INSERT INTO `area_info` VALUES ('611021', '611000', '洛南县', '3');
INSERT INTO `area_info` VALUES ('611022', '611000', '丹凤县', '3');
INSERT INTO `area_info` VALUES ('611023', '611000', '商南县', '3');
INSERT INTO `area_info` VALUES ('611024', '611000', '山阳县', '3');
INSERT INTO `area_info` VALUES ('611025', '611000', '镇安县', '3');
INSERT INTO `area_info` VALUES ('611026', '611000', '柞水县', '3');
INSERT INTO `area_info` VALUES ('620000', null, '甘肃省', '1');
INSERT INTO `area_info` VALUES ('620100', '620000', '兰州市', '2');
INSERT INTO `area_info` VALUES ('620101', '620100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620102', '620100', '城关区', '3');
INSERT INTO `area_info` VALUES ('620103', '620100', '七里河区', '3');
INSERT INTO `area_info` VALUES ('620104', '620100', '西固区', '3');
INSERT INTO `area_info` VALUES ('620105', '620100', '安宁区', '3');
INSERT INTO `area_info` VALUES ('620111', '620100', '红古区', '3');
INSERT INTO `area_info` VALUES ('620121', '620100', '永登县', '3');
INSERT INTO `area_info` VALUES ('620122', '620100', '皋兰县', '3');
INSERT INTO `area_info` VALUES ('620123', '620100', '榆中县', '3');
INSERT INTO `area_info` VALUES ('620200', '620000', '嘉峪关市', '2');
INSERT INTO `area_info` VALUES ('620201', '620200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620300', '620000', '金昌市', '2');
INSERT INTO `area_info` VALUES ('620301', '620300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620302', '620300', '金川区', '3');
INSERT INTO `area_info` VALUES ('620321', '620300', '永昌县', '3');
INSERT INTO `area_info` VALUES ('620400', '620000', '白银市', '2');
INSERT INTO `area_info` VALUES ('620401', '620400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620402', '620400', '白银区', '3');
INSERT INTO `area_info` VALUES ('620403', '620400', '平川区', '3');
INSERT INTO `area_info` VALUES ('620421', '620400', '靖远县', '3');
INSERT INTO `area_info` VALUES ('620422', '620400', '会宁县', '3');
INSERT INTO `area_info` VALUES ('620423', '620400', '景泰县', '3');
INSERT INTO `area_info` VALUES ('620500', '620000', '天水市', '2');
INSERT INTO `area_info` VALUES ('620501', '620500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620502', '620500', '秦州区', '3');
INSERT INTO `area_info` VALUES ('620503', '620500', '麦积区', '3');
INSERT INTO `area_info` VALUES ('620521', '620500', '清水县', '3');
INSERT INTO `area_info` VALUES ('620522', '620500', '秦安县', '3');
INSERT INTO `area_info` VALUES ('620523', '620500', '甘谷县', '3');
INSERT INTO `area_info` VALUES ('620524', '620500', '武山县', '3');
INSERT INTO `area_info` VALUES ('620525', '620500', '张家川回族自治县', '3');
INSERT INTO `area_info` VALUES ('620600', '620000', '武威市', '2');
INSERT INTO `area_info` VALUES ('620601', '620600', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620602', '620600', '凉州区', '3');
INSERT INTO `area_info` VALUES ('620621', '620600', '民勤县', '3');
INSERT INTO `area_info` VALUES ('620622', '620600', '古浪县', '3');
INSERT INTO `area_info` VALUES ('620623', '620600', '天祝藏族自治县', '3');
INSERT INTO `area_info` VALUES ('620700', '620000', '张掖市', '2');
INSERT INTO `area_info` VALUES ('620701', '620700', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620702', '620700', '甘州区', '3');
INSERT INTO `area_info` VALUES ('620721', '620700', '肃南裕固族自治县', '3');
INSERT INTO `area_info` VALUES ('620722', '620700', '民乐县', '3');
INSERT INTO `area_info` VALUES ('620723', '620700', '临泽县', '3');
INSERT INTO `area_info` VALUES ('620724', '620700', '高台县', '3');
INSERT INTO `area_info` VALUES ('620725', '620700', '山丹县', '3');
INSERT INTO `area_info` VALUES ('620800', '620000', '平凉市', '2');
INSERT INTO `area_info` VALUES ('620801', '620800', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620802', '620800', '崆峒区', '3');
INSERT INTO `area_info` VALUES ('620821', '620800', '泾川县', '3');
INSERT INTO `area_info` VALUES ('620822', '620800', '灵台县', '3');
INSERT INTO `area_info` VALUES ('620823', '620800', '崇信县', '3');
INSERT INTO `area_info` VALUES ('620824', '620800', '华亭县', '3');
INSERT INTO `area_info` VALUES ('620825', '620800', '庄浪县', '3');
INSERT INTO `area_info` VALUES ('620826', '620800', '静宁县', '3');
INSERT INTO `area_info` VALUES ('620900', '620000', '酒泉市', '2');
INSERT INTO `area_info` VALUES ('620901', '620900', '市辖区', '3');
INSERT INTO `area_info` VALUES ('620902', '620900', '肃州区', '3');
INSERT INTO `area_info` VALUES ('620921', '620900', '金塔县', '3');
INSERT INTO `area_info` VALUES ('620922', '620900', '瓜州县', '3');
INSERT INTO `area_info` VALUES ('620923', '620900', '肃北蒙古族自治县', '3');
INSERT INTO `area_info` VALUES ('620924', '620900', '阿克塞哈萨克族自治县', '3');
INSERT INTO `area_info` VALUES ('620981', '620900', '玉门市', '3');
INSERT INTO `area_info` VALUES ('620982', '620900', '敦煌市', '3');
INSERT INTO `area_info` VALUES ('621000', '620000', '庆阳市', '2');
INSERT INTO `area_info` VALUES ('621001', '621000', '市辖区', '3');
INSERT INTO `area_info` VALUES ('621002', '621000', '西峰区', '3');
INSERT INTO `area_info` VALUES ('621021', '621000', '庆城县', '3');
INSERT INTO `area_info` VALUES ('621022', '621000', '环县', '3');
INSERT INTO `area_info` VALUES ('621023', '621000', '华池县', '3');
INSERT INTO `area_info` VALUES ('621024', '621000', '合水县', '3');
INSERT INTO `area_info` VALUES ('621025', '621000', '正宁县', '3');
INSERT INTO `area_info` VALUES ('621026', '621000', '宁县', '3');
INSERT INTO `area_info` VALUES ('621027', '621000', '镇原县', '3');
INSERT INTO `area_info` VALUES ('621100', '620000', '定西市', '2');
INSERT INTO `area_info` VALUES ('621101', '621100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('621102', '621100', '安定区', '3');
INSERT INTO `area_info` VALUES ('621121', '621100', '通渭县', '3');
INSERT INTO `area_info` VALUES ('621122', '621100', '陇西县', '3');
INSERT INTO `area_info` VALUES ('621123', '621100', '渭源县', '3');
INSERT INTO `area_info` VALUES ('621124', '621100', '临洮县', '3');
INSERT INTO `area_info` VALUES ('621125', '621100', '漳县', '3');
INSERT INTO `area_info` VALUES ('621126', '621100', '岷县', '3');
INSERT INTO `area_info` VALUES ('621200', '620000', '陇南市', '2');
INSERT INTO `area_info` VALUES ('621201', '621200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('621202', '621200', '武都区', '3');
INSERT INTO `area_info` VALUES ('621221', '621200', '成县', '3');
INSERT INTO `area_info` VALUES ('621222', '621200', '文县', '3');
INSERT INTO `area_info` VALUES ('621223', '621200', '宕昌县', '3');
INSERT INTO `area_info` VALUES ('621224', '621200', '康县', '3');
INSERT INTO `area_info` VALUES ('621225', '621200', '西和县', '3');
INSERT INTO `area_info` VALUES ('621226', '621200', '礼县', '3');
INSERT INTO `area_info` VALUES ('621227', '621200', '徽县', '3');
INSERT INTO `area_info` VALUES ('621228', '621200', '两当县', '3');
INSERT INTO `area_info` VALUES ('622900', '620000', '临夏回族自治州', '2');
INSERT INTO `area_info` VALUES ('622901', '622900', '临夏市', '3');
INSERT INTO `area_info` VALUES ('622921', '622900', '临夏县', '3');
INSERT INTO `area_info` VALUES ('622922', '622900', '康乐县', '3');
INSERT INTO `area_info` VALUES ('622923', '622900', '永靖县', '3');
INSERT INTO `area_info` VALUES ('622924', '622900', '广河县', '3');
INSERT INTO `area_info` VALUES ('622925', '622900', '和政县', '3');
INSERT INTO `area_info` VALUES ('622926', '622900', '东乡族自治县', '3');
INSERT INTO `area_info` VALUES ('622927', '622900', '积石山保安族东乡族撒拉族自治县', '3');
INSERT INTO `area_info` VALUES ('623000', '620000', '甘南藏族自治州', '2');
INSERT INTO `area_info` VALUES ('623001', '623000', '合作市', '3');
INSERT INTO `area_info` VALUES ('623021', '623000', '临潭县', '3');
INSERT INTO `area_info` VALUES ('623022', '623000', '卓尼县', '3');
INSERT INTO `area_info` VALUES ('623023', '623000', '舟曲县', '3');
INSERT INTO `area_info` VALUES ('623024', '623000', '迭部县', '3');
INSERT INTO `area_info` VALUES ('623025', '623000', '玛曲县', '3');
INSERT INTO `area_info` VALUES ('623026', '623000', '碌曲县', '3');
INSERT INTO `area_info` VALUES ('623027', '623000', '夏河县', '3');
INSERT INTO `area_info` VALUES ('630000', null, '青海省', '1');
INSERT INTO `area_info` VALUES ('630100', '630000', '西宁市', '2');
INSERT INTO `area_info` VALUES ('630101', '630100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('630102', '630100', '城东区', '3');
INSERT INTO `area_info` VALUES ('630103', '630100', '城中区', '3');
INSERT INTO `area_info` VALUES ('630104', '630100', '城西区', '3');
INSERT INTO `area_info` VALUES ('630105', '630100', '城北区', '3');
INSERT INTO `area_info` VALUES ('630121', '630100', '大通回族土族自治县', '3');
INSERT INTO `area_info` VALUES ('630122', '630100', '湟中县', '3');
INSERT INTO `area_info` VALUES ('630123', '630100', '湟源县', '3');
INSERT INTO `area_info` VALUES ('630200', '630000', '海东市', '2');
INSERT INTO `area_info` VALUES ('630202', '630200', '乐都区', '3');
INSERT INTO `area_info` VALUES ('630203', '630200', '平安区', '3');
INSERT INTO `area_info` VALUES ('630222', '630200', '民和回族土族自治县', '3');
INSERT INTO `area_info` VALUES ('630223', '630200', '互助土族自治县', '3');
INSERT INTO `area_info` VALUES ('630224', '630200', '化隆回族自治县', '3');
INSERT INTO `area_info` VALUES ('630225', '630200', '循化撒拉族自治县', '3');
INSERT INTO `area_info` VALUES ('632200', '630000', '海北藏族自治州', '2');
INSERT INTO `area_info` VALUES ('632221', '632200', '门源回族自治县', '3');
INSERT INTO `area_info` VALUES ('632222', '632200', '祁连县', '3');
INSERT INTO `area_info` VALUES ('632223', '632200', '海晏县', '3');
INSERT INTO `area_info` VALUES ('632224', '632200', '刚察县', '3');
INSERT INTO `area_info` VALUES ('632300', '630000', '黄南藏族自治州', '2');
INSERT INTO `area_info` VALUES ('632321', '632300', '同仁县', '3');
INSERT INTO `area_info` VALUES ('632322', '632300', '尖扎县', '3');
INSERT INTO `area_info` VALUES ('632323', '632300', '泽库县', '3');
INSERT INTO `area_info` VALUES ('632324', '632300', '河南蒙古族自治县', '3');
INSERT INTO `area_info` VALUES ('632500', '630000', '海南藏族自治州', '2');
INSERT INTO `area_info` VALUES ('632521', '632500', '共和县', '3');
INSERT INTO `area_info` VALUES ('632522', '632500', '同德县', '3');
INSERT INTO `area_info` VALUES ('632523', '632500', '贵德县', '3');
INSERT INTO `area_info` VALUES ('632524', '632500', '兴海县', '3');
INSERT INTO `area_info` VALUES ('632525', '632500', '贵南县', '3');
INSERT INTO `area_info` VALUES ('632600', '630000', '果洛藏族自治州', '2');
INSERT INTO `area_info` VALUES ('632621', '632600', '玛沁县', '3');
INSERT INTO `area_info` VALUES ('632622', '632600', '班玛县', '3');
INSERT INTO `area_info` VALUES ('632623', '632600', '甘德县', '3');
INSERT INTO `area_info` VALUES ('632624', '632600', '达日县', '3');
INSERT INTO `area_info` VALUES ('632625', '632600', '久治县', '3');
INSERT INTO `area_info` VALUES ('632626', '632600', '玛多县', '3');
INSERT INTO `area_info` VALUES ('632700', '630000', '玉树藏族自治州', '2');
INSERT INTO `area_info` VALUES ('632701', '632700', '玉树市', '3');
INSERT INTO `area_info` VALUES ('632722', '632700', '杂多县', '3');
INSERT INTO `area_info` VALUES ('632723', '632700', '称多县', '3');
INSERT INTO `area_info` VALUES ('632724', '632700', '治多县', '3');
INSERT INTO `area_info` VALUES ('632725', '632700', '囊谦县', '3');
INSERT INTO `area_info` VALUES ('632726', '632700', '曲麻莱县', '3');
INSERT INTO `area_info` VALUES ('632800', '630000', '海西蒙古族藏族自治州', '2');
INSERT INTO `area_info` VALUES ('632801', '632800', '格尔木市', '3');
INSERT INTO `area_info` VALUES ('632802', '632800', '德令哈市', '3');
INSERT INTO `area_info` VALUES ('632821', '632800', '乌兰县', '3');
INSERT INTO `area_info` VALUES ('632822', '632800', '都兰县', '3');
INSERT INTO `area_info` VALUES ('632823', '632800', '天峻县', '3');
INSERT INTO `area_info` VALUES ('640000', null, '宁夏自治区', '1');
INSERT INTO `area_info` VALUES ('640100', '640000', '银川市', '2');
INSERT INTO `area_info` VALUES ('640101', '640100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('640104', '640100', '兴庆区', '3');
INSERT INTO `area_info` VALUES ('640105', '640100', '西夏区', '3');
INSERT INTO `area_info` VALUES ('640106', '640100', '金凤区', '3');
INSERT INTO `area_info` VALUES ('640121', '640100', '永宁县', '3');
INSERT INTO `area_info` VALUES ('640122', '640100', '贺兰县', '3');
INSERT INTO `area_info` VALUES ('640181', '640100', '灵武市', '3');
INSERT INTO `area_info` VALUES ('640200', '640000', '石嘴山市', '2');
INSERT INTO `area_info` VALUES ('640201', '640200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('640202', '640200', '大武口区', '3');
INSERT INTO `area_info` VALUES ('640205', '640200', '惠农区', '3');
INSERT INTO `area_info` VALUES ('640221', '640200', '平罗县', '3');
INSERT INTO `area_info` VALUES ('640300', '640000', '吴忠市', '2');
INSERT INTO `area_info` VALUES ('640301', '640300', '市辖区', '3');
INSERT INTO `area_info` VALUES ('640400', '640000', '固原市', '2');
INSERT INTO `area_info` VALUES ('640401', '640400', '市辖区', '3');
INSERT INTO `area_info` VALUES ('640402', '640400', '原州区', '3');
INSERT INTO `area_info` VALUES ('640422', '640400', '西吉县', '3');
INSERT INTO `area_info` VALUES ('640423', '640400', '隆德县', '3');
INSERT INTO `area_info` VALUES ('640424', '640400', '泾源县', '3');
INSERT INTO `area_info` VALUES ('640425', '640400', '彭阳县', '3');
INSERT INTO `area_info` VALUES ('640500', '640000', '中卫市', '2');
INSERT INTO `area_info` VALUES ('640501', '640500', '市辖区', '3');
INSERT INTO `area_info` VALUES ('640502', '640500', '沙坡头区', '3');
INSERT INTO `area_info` VALUES ('640521', '640500', '中宁县', '3');
INSERT INTO `area_info` VALUES ('640522', '640500', '海原县', '3');
INSERT INTO `area_info` VALUES ('650000', null, '新疆自治区', '1');
INSERT INTO `area_info` VALUES ('650100', '650000', '乌鲁木齐市', '2');
INSERT INTO `area_info` VALUES ('650101', '650100', '市辖区', '3');
INSERT INTO `area_info` VALUES ('650102', '650100', '天山区', '3');
INSERT INTO `area_info` VALUES ('650103', '650100', '沙依巴克区', '3');
INSERT INTO `area_info` VALUES ('650104', '650100', '新市区', '3');
INSERT INTO `area_info` VALUES ('650105', '650100', '水磨沟区', '3');
INSERT INTO `area_info` VALUES ('650106', '650100', '头屯河区', '3');
INSERT INTO `area_info` VALUES ('650107', '650100', '达坂城区', '3');
INSERT INTO `area_info` VALUES ('650109', '650100', '米东区', '3');
INSERT INTO `area_info` VALUES ('650121', '650100', '乌鲁木齐县', '3');
INSERT INTO `area_info` VALUES ('650200', '650000', '克拉玛依市', '2');
INSERT INTO `area_info` VALUES ('650201', '650200', '市辖区', '3');
INSERT INTO `area_info` VALUES ('650202', '650200', '独山子区', '3');
INSERT INTO `area_info` VALUES ('650203', '650200', '克拉玛依区', '3');
INSERT INTO `area_info` VALUES ('650204', '650200', '白碱滩区', '3');
INSERT INTO `area_info` VALUES ('650205', '650200', '乌尔禾区', '3');
INSERT INTO `area_info` VALUES ('650400', '650000', '吐鲁番市', '2');
INSERT INTO `area_info` VALUES ('650402', '650400', '高昌区', '3');
INSERT INTO `area_info` VALUES ('650421', '650400', '鄯善县', '3');
INSERT INTO `area_info` VALUES ('650422', '650400', '托克逊县', '3');
INSERT INTO `area_info` VALUES ('650500', '650000', '哈密市', '2');
INSERT INTO `area_info` VALUES ('650502', '650500', '伊州区', '3');
INSERT INTO `area_info` VALUES ('650521', '650500', '巴里坤哈萨克自治县', '3');
INSERT INTO `area_info` VALUES ('650522', '650500', '伊吾县', '3');
INSERT INTO `area_info` VALUES ('652300', '650000', '昌吉回族自治州', '2');
INSERT INTO `area_info` VALUES ('652301', '652300', '昌吉市', '3');
INSERT INTO `area_info` VALUES ('652302', '652300', '阜康市', '3');
INSERT INTO `area_info` VALUES ('652323', '652300', '呼图壁县', '3');
INSERT INTO `area_info` VALUES ('652324', '652300', '玛纳斯县', '3');
INSERT INTO `area_info` VALUES ('652325', '652300', '奇台县', '3');
INSERT INTO `area_info` VALUES ('652327', '652300', '吉木萨尔县', '3');
INSERT INTO `area_info` VALUES ('652328', '652300', '木垒哈萨克自治县', '3');
INSERT INTO `area_info` VALUES ('652700', '650000', '博尔塔拉蒙古自治州', '2');
INSERT INTO `area_info` VALUES ('652701', '652700', '博乐市', '3');
INSERT INTO `area_info` VALUES ('652702', '652700', '阿拉山口市', '3');
INSERT INTO `area_info` VALUES ('652722', '652700', '精河县', '3');
INSERT INTO `area_info` VALUES ('652723', '652700', '温泉县', '3');
INSERT INTO `area_info` VALUES ('652800', '650000', '巴音郭楞蒙古自治州', '2');
INSERT INTO `area_info` VALUES ('652801', '652800', '库尔勒市', '3');
INSERT INTO `area_info` VALUES ('652822', '652800', '轮台县', '3');
INSERT INTO `area_info` VALUES ('652823', '652800', '尉犁县', '3');
INSERT INTO `area_info` VALUES ('652824', '652800', '若羌县', '3');
INSERT INTO `area_info` VALUES ('652825', '652800', '且末县', '3');
INSERT INTO `area_info` VALUES ('652826', '652800', '焉耆回族自治县', '3');
INSERT INTO `area_info` VALUES ('652827', '652800', '和静县', '3');
INSERT INTO `area_info` VALUES ('652828', '652800', '和硕县', '3');
INSERT INTO `area_info` VALUES ('652829', '652800', '博湖县', '3');
INSERT INTO `area_info` VALUES ('652900', '650000', '阿克苏地区', '2');
INSERT INTO `area_info` VALUES ('652901', '652900', '阿克苏市', '3');
INSERT INTO `area_info` VALUES ('652922', '652900', '温宿县', '3');
INSERT INTO `area_info` VALUES ('652923', '652900', '库车县', '3');
INSERT INTO `area_info` VALUES ('652924', '652900', '沙雅县', '3');
INSERT INTO `area_info` VALUES ('652925', '652900', '新和县', '3');
INSERT INTO `area_info` VALUES ('652926', '652900', '拜城县', '3');
INSERT INTO `area_info` VALUES ('652927', '652900', '乌什县', '3');
INSERT INTO `area_info` VALUES ('652928', '652900', '阿瓦提县', '3');
INSERT INTO `area_info` VALUES ('652929', '652900', '柯坪县', '3');
INSERT INTO `area_info` VALUES ('653000', '650000', '克孜勒苏柯尔克孜自治州', '2');
INSERT INTO `area_info` VALUES ('653001', '653000', '阿图什市', '3');
INSERT INTO `area_info` VALUES ('653022', '653000', '阿克陶县', '3');
INSERT INTO `area_info` VALUES ('653023', '653000', '阿合奇县', '3');
INSERT INTO `area_info` VALUES ('653024', '653000', '乌恰县', '3');
INSERT INTO `area_info` VALUES ('653100', '650000', '喀什地区', '2');
INSERT INTO `area_info` VALUES ('653101', '653100', '喀什市', '3');
INSERT INTO `area_info` VALUES ('653121', '653100', '疏附县', '3');
INSERT INTO `area_info` VALUES ('653122', '653100', '疏勒县', '3');
INSERT INTO `area_info` VALUES ('653123', '653100', '英吉沙县', '3');
INSERT INTO `area_info` VALUES ('653124', '653100', '泽普县', '3');
INSERT INTO `area_info` VALUES ('653125', '653100', '莎车县', '3');
INSERT INTO `area_info` VALUES ('653126', '653100', '叶城县', '3');
INSERT INTO `area_info` VALUES ('653127', '653100', '麦盖提县', '3');
INSERT INTO `area_info` VALUES ('653128', '653100', '岳普湖县', '3');
INSERT INTO `area_info` VALUES ('653129', '653100', '伽师县', '3');
INSERT INTO `area_info` VALUES ('653130', '653100', '巴楚县', '3');
INSERT INTO `area_info` VALUES ('653131', '653100', '塔什库尔干塔吉克自治县', '3');
INSERT INTO `area_info` VALUES ('653200', '650000', '和田地区', '2');
INSERT INTO `area_info` VALUES ('653201', '653200', '和田市', '3');
INSERT INTO `area_info` VALUES ('653221', '653200', '和田县', '3');
INSERT INTO `area_info` VALUES ('653222', '653200', '墨玉县', '3');
INSERT INTO `area_info` VALUES ('653223', '653200', '皮山县', '3');
INSERT INTO `area_info` VALUES ('653224', '653200', '洛浦县', '3');
INSERT INTO `area_info` VALUES ('653225', '653200', '策勒县', '3');
INSERT INTO `area_info` VALUES ('653226', '653200', '于田县', '3');
INSERT INTO `area_info` VALUES ('653227', '653200', '民丰县', '3');
INSERT INTO `area_info` VALUES ('654000', '650000', '伊犁哈萨克自治州', '2');
INSERT INTO `area_info` VALUES ('654002', '654000', '伊宁市', '3');
INSERT INTO `area_info` VALUES ('654003', '654000', '奎屯市', '3');
INSERT INTO `area_info` VALUES ('654004', '654000', '霍尔果斯市', '3');
INSERT INTO `area_info` VALUES ('654021', '654000', '伊宁县', '3');
INSERT INTO `area_info` VALUES ('654022', '654000', '察布查尔锡伯自治县', '3');
INSERT INTO `area_info` VALUES ('654023', '654000', '霍城县', '3');
INSERT INTO `area_info` VALUES ('654024', '654000', '巩留县', '3');
INSERT INTO `area_info` VALUES ('654025', '654000', '新源县', '3');
INSERT INTO `area_info` VALUES ('654026', '654000', '昭苏县', '3');
INSERT INTO `area_info` VALUES ('654027', '654000', '特克斯县', '3');
INSERT INTO `area_info` VALUES ('654028', '654000', '尼勒克县', '3');
INSERT INTO `area_info` VALUES ('654200', '650000', '塔城地区', '2');
INSERT INTO `area_info` VALUES ('654201', '654200', '塔城市', '3');
INSERT INTO `area_info` VALUES ('654202', '654200', '乌苏市', '3');
INSERT INTO `area_info` VALUES ('654221', '654200', '额敏县', '3');
INSERT INTO `area_info` VALUES ('654223', '654200', '沙湾县', '3');
INSERT INTO `area_info` VALUES ('654224', '654200', '托里县', '3');
INSERT INTO `area_info` VALUES ('654225', '654200', '裕民县', '3');
INSERT INTO `area_info` VALUES ('654226', '654200', '和布克赛尔蒙古自治县', '3');
INSERT INTO `area_info` VALUES ('654300', '650000', '阿勒泰地区', '2');
INSERT INTO `area_info` VALUES ('654301', '654300', '阿勒泰市', '3');
INSERT INTO `area_info` VALUES ('654321', '654300', '布尔津县', '3');
INSERT INTO `area_info` VALUES ('654322', '654300', '富蕴县', '3');
INSERT INTO `area_info` VALUES ('654323', '654300', '福海县', '3');
INSERT INTO `area_info` VALUES ('654324', '654300', '哈巴河县', '3');
INSERT INTO `area_info` VALUES ('654325', '654300', '青河县', '3');
INSERT INTO `area_info` VALUES ('654326', '654300', '吉木乃县', '3');
INSERT INTO `area_info` VALUES ('659000', '650000', '自治区直辖县级行政区划', '2');
INSERT INTO `area_info` VALUES ('659001', '659000', '石河子市', '3');
INSERT INTO `area_info` VALUES ('659002', '659000', '阿拉尔市', '3');
INSERT INTO `area_info` VALUES ('659003', '659000', '图木舒克市', '3');
INSERT INTO `area_info` VALUES ('659004', '659000', '五家渠市', '3');
INSERT INTO `area_info` VALUES ('659006', '659000', '铁门关市', '3');
INSERT INTO `area_info` VALUES ('710000', null, '台湾省', '1');
INSERT INTO `area_info` VALUES ('710100', '710000', '市辖区', '2');
INSERT INTO `area_info` VALUES ('710101', '710100', '台北市', '3');
INSERT INTO `area_info` VALUES ('710102', '710100', '新北市', '3');
INSERT INTO `area_info` VALUES ('710103', '710100', '桃园市', '3');
INSERT INTO `area_info` VALUES ('710104', '710100', '台中市', '3');
INSERT INTO `area_info` VALUES ('710105', '710100', '台南市', '3');
INSERT INTO `area_info` VALUES ('710106', '710100', '高雄市', '3');
INSERT INTO `area_info` VALUES ('810000', null, '香港', '1');
INSERT INTO `area_info` VALUES ('810100', '810000', '香港岛', '2');
INSERT INTO `area_info` VALUES ('810101', '810100', '香港岛中西区', '3');
INSERT INTO `area_info` VALUES ('810102', '810100', '香港岛湾仔', '3');
INSERT INTO `area_info` VALUES ('810103', '810100', '香港岛东区', '3');
INSERT INTO `area_info` VALUES ('810104', '810100', '香港岛南区', '3');
INSERT INTO `area_info` VALUES ('810200', '810000', '九龙', '2');
INSERT INTO `area_info` VALUES ('810201', '810200', '九龙九龙城区', '3');
INSERT INTO `area_info` VALUES ('810202', '810200', '九龙油尖旺区', '3');
INSERT INTO `area_info` VALUES ('810203', '810200', '九龙深水埗区', '3');
INSERT INTO `area_info` VALUES ('810204', '810200', '九龙黄大仙区', '3');
INSERT INTO `area_info` VALUES ('810205', '810200', '九龙观塘区', '3');
INSERT INTO `area_info` VALUES ('810300', '810000', '新界', '2');
INSERT INTO `area_info` VALUES ('810301', '810300', '新界北区', '3');
INSERT INTO `area_info` VALUES ('810302', '810300', '新界大埔区', '3');
INSERT INTO `area_info` VALUES ('810303', '810300', '新界沙田区', '3');
INSERT INTO `area_info` VALUES ('810304', '810300', '新界西贡区', '3');
INSERT INTO `area_info` VALUES ('810305', '810300', '新界元朗区', '3');
INSERT INTO `area_info` VALUES ('810306', '810300', '新界屯门区', '3');
INSERT INTO `area_info` VALUES ('810307', '810300', '新界荃湾区', '3');
INSERT INTO `area_info` VALUES ('810308', '810300', '新界葵青区', '3');
INSERT INTO `area_info` VALUES ('810309', '810300', '新界离岛区', '3');
INSERT INTO `area_info` VALUES ('820000', null, '澳门', '1');
INSERT INTO `area_info` VALUES ('820100', '820000', '澳门半岛', '2');
INSERT INTO `area_info` VALUES ('820101', '820100', '花地玛堂区', '3');
INSERT INTO `area_info` VALUES ('820102', '820100', '圣安多尼堂区', '3');
INSERT INTO `area_info` VALUES ('820103', '820100', '大堂区', '3');
INSERT INTO `area_info` VALUES ('820104', '820100', '望德堂区', '3');
INSERT INTO `area_info` VALUES ('820105', '820100', '风顺堂区', '3');
INSERT INTO `area_info` VALUES ('820200', '820000', '离岛', '2');
INSERT INTO `area_info` VALUES ('820201', '820200', '嘉模堂区', '3');
INSERT INTO `area_info` VALUES ('820202', '820200', '圣方济各堂区', '3');
INSERT INTO `area_info` VALUES ('820300', '820000', '路氹城', '2');
INSERT INTO `area_info` VALUES ('820301', '820300', '路氹城', '3');

-- ----------------------------
-- Table structure for attach_file
-- ----------------------------
DROP TABLE IF EXISTS `attach_file`;
CREATE TABLE `attach_file` (
  `file_id` varchar(32) NOT NULL,
  `file_type` char(1) DEFAULT NULL,
  `file_name` varchar(128) NOT NULL,
  `save_name` varchar(128) NOT NULL,
  `state` char(1) NOT NULL DEFAULT 'T',
  `sts` char(1) NOT NULL DEFAULT 'A',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attach_file
-- ----------------------------

-- ----------------------------
-- Table structure for certificates_type
-- ----------------------------
DROP TABLE IF EXISTS `certificates_type`;
CREATE TABLE `certificates_type` (
  `certificates_type_id` int(10) NOT NULL AUTO_INCREMENT,
  `certificates_type_name` varchar(64) DEFAULT NULL,
  `list_order` int(4) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`certificates_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of certificates_type
-- ----------------------------
INSERT INTO `certificates_type` VALUES ('1', '身份证', '1', '2019-10-28 10:48:35', null, 'A');

-- ----------------------------
-- Table structure for community_info
-- ----------------------------
DROP TABLE IF EXISTS `community_info`;
CREATE TABLE `community_info` (
  `community_id` int(10) NOT NULL AUTO_INCREMENT,
  `community_name` varchar(128) DEFAULT NULL,
  `list_order` int(4) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  `prov_code` varchar(20) DEFAULT NULL,
  `prov_name` varchar(20) DEFAULT NULL,
  `city_code` varchar(20) DEFAULT NULL,
  `city_name` varchar(20) DEFAULT NULL,
  `area_code` varchar(20) DEFAULT NULL,
  `area_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`community_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_info
-- ----------------------------
INSERT INTO `community_info` VALUES ('1', '社区1', '12', '2019-10-29 09:05:48', '2019-10-31 16:44:35', 'A', '130000', '河北省', '130100', '石家庄市', '130108', '裕华区');
INSERT INTO `community_info` VALUES ('2', '社区20', '2', '2019-10-29 09:05:58', '2019-10-31 16:44:51', 'A', '130000', '河北省', '130100', '石家庄市', '130109', '藁城区');
INSERT INTO `community_info` VALUES ('3', '社区3', '1', '2019-10-29 09:06:06', '2019-10-30 18:47:24', 'A', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('5', '社区6', '6', '2019-10-30 17:51:27', '2019-10-30 18:48:30', 'A', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('6', '社区5', '5', '2019-10-30 17:51:54', '2019-10-31 16:44:30', 'A', '130000', '河北省', '130100', '石家庄市', '130102', '长安区');
INSERT INTO `community_info` VALUES ('7', '社区8', '4', '2019-10-30 17:52:43', '2019-10-31 16:44:24', 'A', '130000', '河北省', '130100', '石家庄市', '130102', '长安区');
INSERT INTO `community_info` VALUES ('8', '社区11', '1', '2019-10-30 18:02:13', '2019-11-01 14:42:22', 'A', '130000', '河北省', '130100', '石家庄市', '130104', '桥西区');
INSERT INTO `community_info` VALUES ('9', '11', '1', '2019-10-30 18:02:43', '2019-10-31 09:35:10', 'P', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('10', '111', '11', '2019-10-30 18:02:49', '2019-10-31 09:35:39', 'P', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('11', '1112', '1', '2019-10-30 18:02:53', '2019-10-31 09:35:07', 'P', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('12', '11111', '11', '2019-10-30 18:02:59', '2019-10-31 09:35:41', 'P', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('13', '22', '3', '2019-10-30 18:03:03', '2019-10-31 09:35:35', 'P', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('14', '和克拉玛依裕华社区', '1', '2019-10-31 09:36:53', '2019-10-31 10:04:41', 'A', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('15', '打发斯蒂芬爱是范德萨发生的发生地方 阿斯顿发生', '2', '2019-10-31 09:37:04', '2019-10-31 09:37:18', 'P', '130000', '河北省', '130100', '石家庄市', '130104', '新华区');
INSERT INTO `community_info` VALUES ('16', '谈固', '1', '2019-10-31 15:53:23', '2019-10-31 16:43:14', 'A', '130000', '河北省', '130100', '石家庄市', '130102', '长安区');
INSERT INTO `community_info` VALUES ('17', '1', '1', '2019-10-31 16:43:55', '2019-11-01 14:41:29', 'P', '120000', '天津市', '120100', '天津市', '120102', '河东区');

-- ----------------------------
-- Table structure for community_street_info
-- ----------------------------
DROP TABLE IF EXISTS `community_street_info`;
CREATE TABLE `community_street_info` (
  `community_street_id` int(10) NOT NULL AUTO_INCREMENT,
  `community_street_name` varchar(128) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '1小区2街道',
  `community_id` int(10) DEFAULT NULL,
  `list_order` int(4) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`community_street_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_street_info
-- ----------------------------
INSERT INTO `community_street_info` VALUES ('1', '小区1', '1', '1', '1', '2019-10-29 09:37:17', '2019-10-30 19:44:54', 'A');
INSERT INTO `community_street_info` VALUES ('2', '小区2', '1', '1', '2', '2019-10-29 09:37:32', '2019-10-30 19:44:54', 'A');
INSERT INTO `community_street_info` VALUES ('3', '街道1', '2', '1', '3', '2019-10-29 09:37:51', '2019-10-31 10:07:29', 'A');
INSERT INTO `community_street_info` VALUES ('4', '街道3', '2', '3', '4', '2019-10-29 09:39:16', null, 'A');
INSERT INTO `community_street_info` VALUES ('5', '小区3', '1', '3', '1', '2019-10-29 09:39:41', '2019-10-31 18:12:56', 'A');
INSERT INTO `community_street_info` VALUES ('6', '小区8', '1', '2', '1', '2019-10-30 20:06:22', '2019-10-31 18:13:19', 'A');
INSERT INTO `community_street_info` VALUES ('7', '同安小区', '1', '2', '1', '2019-10-31 17:51:38', null, 'A');
INSERT INTO `community_street_info` VALUES ('8', '瑞成A区', '1', '16', '2', '2019-11-01 09:26:29', null, 'A');
INSERT INTO `community_street_info` VALUES ('9', '瑞成B区', '1', '16', '3', '2019-11-01 09:26:44', null, 'A');
INSERT INTO `community_street_info` VALUES ('10', '瑞成C区', '1', '16', '3', '2019-11-01 09:26:57', null, 'A');
INSERT INTO `community_street_info` VALUES ('11', '金谈固小区', '1', '16', '1', '2019-11-01 09:27:13', null, 'A');

-- ----------------------------
-- Table structure for contract_file
-- ----------------------------
DROP TABLE IF EXISTS `contract_file`;
CREATE TABLE `contract_file` (
  `file_id` int(10) NOT NULL AUTO_INCREMENT,
  `personnel_id` int(10) DEFAULT NULL,
  `houses_id` int(10) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `file_thumb` varchar(512) DEFAULT NULL COMMENT '文件路径地址',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract_file
-- ----------------------------
INSERT INTO `contract_file` VALUES ('1', '4', '2', null, '/jianfuzengxiao/attached/idcard/idcard_zheng.png', '2019-11-01 16:59:33', null, 'A');
INSERT INTO `contract_file` VALUES ('2', '4', '2', null, '/jianfuzengxiao/attached/idcard/idcard_zheng.png', '2019-11-01 17:00:01', null, 'A');
INSERT INTO `contract_file` VALUES ('3', '4', '2', null, '/jianfuzengxiao/attached/idcard/idcard_zheng.png', '2019-11-01 17:00:07', null, 'A');

-- ----------------------------
-- Table structure for func_list
-- ----------------------------
DROP TABLE IF EXISTS `func_list`;
CREATE TABLE `func_list` (
  `func_id` int(10) unsigned NOT NULL,
  `parent_id` int(10) unsigned DEFAULT NULL,
  `menu_title` varchar(50) DEFAULT NULL,
  `menu_desc` varchar(100) DEFAULT NULL,
  `menu_icon` varchar(100) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `menu_level` int(10) DEFAULT NULL,
  `list_order` int(10) unsigned DEFAULT NULL,
  `right_code` varchar(50) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `sts` char(1) NOT NULL,
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of func_list
-- ----------------------------

-- ----------------------------
-- Table structure for houses_info
-- ----------------------------
DROP TABLE IF EXISTS `houses_info`;
CREATE TABLE `houses_info` (
  `houses_id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_id` int(10) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `houses_status` int(4) NOT NULL COMMENT '1 房屋、2 店铺',
  `property_owner_name` varchar(32) DEFAULT NULL COMMENT '房屋（门店）产权人姓名',
  `property_owner_tel` varchar(16) DEFAULT NULL COMMENT '房屋（门店）产权人联系电话',
  `property_owner_idcard` varchar(20) DEFAULT NULL COMMENT '房屋（门店）产权人身份证号',
  `property_certificates_number` varchar(128) DEFAULT NULL COMMENT '房屋（门店）产权证号',
  `property_certificates_photo` varchar(512) DEFAULT NULL COMMENT '房屋（门店）房产证照片',
  `property_certificates_file` varchar(32) DEFAULT NULL,
  `community_id` int(10) DEFAULT NULL,
  `community_name` varchar(128) DEFAULT NULL,
  `community_street_id` int(10) DEFAULT NULL,
  `community_street_name` varchar(128) DEFAULT NULL,
  `house_type` varchar(128) DEFAULT NULL COMMENT '房屋（门店）户型',
  `house_type_photo` varchar(512) DEFAULT NULL COMMENT '房屋（门店）户型图',
  `house_type_file` varchar(32) DEFAULT NULL,
  `storied_building_number` varchar(16) DEFAULT NULL COMMENT '房屋楼号',
  `unit` varchar(16) DEFAULT NULL COMMENT '房屋单元',
  `house_number` varchar(16) DEFAULT NULL COMMENT '门牌号',
  `houses_address` varchar(512) DEFAULT NULL COMMENT '房屋（门店）详细地址',
  `houses_type_id` int(10) DEFAULT NULL,
  `houses_type_name` varchar(32) DEFAULT NULL,
  `store_location` int(1) DEFAULT NULL COMMENT '门店0无1内/2外铺',
  `prov_name` varchar(16) DEFAULT NULL,
  `prov_code` varchar(16) DEFAULT NULL,
  `city_name` varchar(16) DEFAULT NULL,
  `city_code` varchar(16) DEFAULT NULL,
  `area_name` varchar(16) DEFAULT NULL,
  `area_code` varchar(16) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`houses_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of houses_info
-- ----------------------------
INSERT INTO `houses_info` VALUES ('1', '1', null, '1', '张三', '13000000000', '1300000000000', '1112331112221', '/jianfuzengxiao/data/attach/image/fangchangzheng/20191101/ea96a7f94ad443a4bfe8915b3c66f9b4.jpg', null, '2', '社区20', '7', '同安小区', '两室一厅', '/jianfuzengxiao/data/attach/image/huxingtu/20191101/29634f834ffc42d58bad67e6d1972d81.jpg', null, '10', '2', '2204', '哈哈哈哈哈哈', '1', '自建房', null, '河北省', '130000', '石家庄市', '130100', '藁城区', '130109', '2019-10-31 15:33:06', '2019-11-01 15:36:45', 'A');
INSERT INTO `houses_info` VALUES ('2', '1', null, '2', '李四', '18000000000', '1500000000000', '1320000000000', '/jianfuzengxiao/data/attach/image/fangchangzheng/20191101/ea96a7f94ad443a4bfe8915b3c66f9b4.jpg', null, '16', '谈固', '10', '瑞成C区', '三室一厅', '/jianfuzengxiao/data/attach/image/huxingtu/20191101/29634f834ffc42d58bad67e6d1972d81.jpg', null, '5', '1', '1102', '呵呵呵呵呵呵', '3', '商铺', null, '河北省', '130000', '石家庄市', '130100', '长安区', '130102', '2019-10-31 15:35:55', '2019-11-01 19:05:27', 'A');
INSERT INTO `houses_info` VALUES ('3', '1', null, '1', '刘三少', '18332332333', '13018209215825311633', '123145614565616516', '/jianfuzengxiao/data/attach/image/fangchangzheng/20191101/ea96a7f94ad443a4bfe8915b3c66f9b4.jpg', null, '16', '谈固', '9', '瑞成B区', '三室一厅', '/jianfuzengxiao/data/attach/image/huxingtu/20191101/29634f834ffc42d58bad67e6d1972d81.jpg', null, '10', '2', '1001', '中山路与谈固东街北行500米', '2', '商住房', null, '河北省', '130000', '石家庄市', '130100', '长安区', '130102', '2019-11-01 14:08:22', '2019-11-01 16:01:26', 'A');
INSERT INTO `houses_info` VALUES ('4', '1', null, '1', '郝建', '13131003100', '541566565656633', '15165156156', '/jianfuzengxiao/data/attach/image/fangchangzheng/20191101/361e34a91d63429aadef5618badf0fca.jpg', null, '16', '谈固', '11', '金谈固小区', '三室两厅', '/jianfuzengxiao/data/attach/image/huxingtu/20191101/9eaabe065a9143dc899fd8d53c852ba8.jpg', null, '3', '1', '405', '中山路133号', '2', '商住房', null, '河北省', '130000', '石家庄市', '130100', '长安区', '130102', '2019-11-01 14:12:49', '2019-11-01 16:01:26', 'A');

-- ----------------------------
-- Table structure for houses_type
-- ----------------------------
DROP TABLE IF EXISTS `houses_type`;
CREATE TABLE `houses_type` (
  `houses_type_id` int(10) NOT NULL AUTO_INCREMENT,
  `houses_type_name` varchar(20) DEFAULT NULL COMMENT '1自建房2商住房3 商铺',
  `list_order` int(4) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`houses_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of houses_type
-- ----------------------------
INSERT INTO `houses_type` VALUES ('1', '自建房', null, '2019-10-31 15:32:22', null, 'A');
INSERT INTO `houses_type` VALUES ('2', '商住房', null, '2019-10-31 15:32:31', null, 'A');
INSERT INTO `houses_type` VALUES ('3', '商铺', null, '2019-10-31 15:32:39', null, 'A');

-- ----------------------------
-- Table structure for live_type
-- ----------------------------
DROP TABLE IF EXISTS `live_type`;
CREATE TABLE `live_type` (
  `live_type_id` int(10) NOT NULL AUTO_INCREMENT,
  `live_type_name` varchar(20) DEFAULT NULL COMMENT '1自有（即房主和店主）2租赁（即房主和店主）3租户（员工）4家属',
  `list_order` int(4) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`live_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of live_type
-- ----------------------------
INSERT INTO `live_type` VALUES ('1', '房主（产权人）', '1', '2019-10-28 18:11:25', null, 'A');
INSERT INTO `live_type` VALUES ('2', '店主（产权人）', '2', '2019-10-28 18:11:41', null, 'A');
INSERT INTO `live_type` VALUES ('3', '房主（租赁）', '3', '2019-10-28 18:11:54', null, 'A');
INSERT INTO `live_type` VALUES ('4', '店主（租赁）', '4', '2019-10-28 18:12:04', null, 'A');
INSERT INTO `live_type` VALUES ('5', '租户', '5', '2019-10-28 18:12:15', null, 'A');
INSERT INTO `live_type` VALUES ('6', '员工', '6', '2019-10-28 18:12:31', null, 'A');
INSERT INTO `live_type` VALUES ('7', '家属', '7', '2019-10-28 18:12:44', null, 'A');

-- ----------------------------
-- Table structure for msg_info
-- ----------------------------
DROP TABLE IF EXISTS `msg_info`;
CREATE TABLE `msg_info` (
  `msg_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) DEFAULT NULL,
  `personnel_id` int(10) DEFAULT NULL,
  `msg_type_id` int(10) DEFAULT NULL,
  `msg_type_name` varchar(32) NOT NULL,
  `title` varchar(128) NOT NULL DEFAULT '',
  `content` varchar(512) DEFAULT '',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '1 未读 2 已读',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_info
-- ----------------------------
INSERT INTO `msg_info` VALUES ('1', '1', '1', '1', '申请已提报', '111', '111111111111111111111', '1', '2019-11-01 19:55:22', null, 'A');
INSERT INTO `msg_info` VALUES ('2', '1', '1', '1', '申请已提报', '222', '22222222222222222222', '1', '2019-11-01 19:55:54', null, 'A');
INSERT INTO `msg_info` VALUES ('3', '1', '1', '2', '过期', '333', '3333333333333333333333', '1', '2019-11-01 19:56:08', null, 'A');
INSERT INTO `msg_info` VALUES ('4', '1', '2', '3', '审核未通过', '444', '44444444444444444444444', '1', '2019-11-01 19:56:20', null, 'A');
INSERT INTO `msg_info` VALUES ('5', '1', '1', '4', '审核通过', '555', '555555555555555555', '1', '2019-11-01 19:56:33', null, 'A');
INSERT INTO `msg_info` VALUES ('6', '1', '3', '5', '身份信息更新提报', '666', '666666666666666', '1', '2019-11-01 19:57:04', null, 'A');
INSERT INTO `msg_info` VALUES ('7', '1', '4', '3', '审核未通过', '777', '77777777777777', '1', '2019-11-01 19:57:11', null, 'A');

-- ----------------------------
-- Table structure for msg_type
-- ----------------------------
DROP TABLE IF EXISTS `msg_type`;
CREATE TABLE `msg_type` (
  `msg_type_id` int(10) NOT NULL AUTO_INCREMENT,
  `msg_type_name` varchar(128) DEFAULT NULL,
  `list_order` int(4) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`msg_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_type
-- ----------------------------
INSERT INTO `msg_type` VALUES ('1', '申请已提报', '1', '2019-10-28 18:23:37', null, 'A');
INSERT INTO `msg_type` VALUES ('2', '过期', '2', '2019-10-28 18:23:49', null, 'A');
INSERT INTO `msg_type` VALUES ('3', '审核未通过', '3', '2019-10-28 18:24:01', null, 'A');
INSERT INTO `msg_type` VALUES ('4', '审核通过', '4', '2019-10-28 18:24:30', null, 'A');
INSERT INTO `msg_type` VALUES ('5', '身份信息更新提报', '5', '2019-10-28 18:34:47', null, 'A');

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation` (
  `nation_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nation_name` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`nation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nation
-- ----------------------------
INSERT INTO `nation` VALUES ('1', '汉族');
INSERT INTO `nation` VALUES ('2', '蒙古族');
INSERT INTO `nation` VALUES ('3', '回族');
INSERT INTO `nation` VALUES ('4', '藏族');
INSERT INTO `nation` VALUES ('5', '维吾尔族');
INSERT INTO `nation` VALUES ('6', '苗族');
INSERT INTO `nation` VALUES ('7', '彝族');
INSERT INTO `nation` VALUES ('8', '壮族');
INSERT INTO `nation` VALUES ('9', '布依族');
INSERT INTO `nation` VALUES ('10', '朝鲜族');
INSERT INTO `nation` VALUES ('11', '满族');
INSERT INTO `nation` VALUES ('12', '侗族');
INSERT INTO `nation` VALUES ('13', '瑶族');
INSERT INTO `nation` VALUES ('14', '白族');
INSERT INTO `nation` VALUES ('15', '土家族');
INSERT INTO `nation` VALUES ('16', '哈尼族');
INSERT INTO `nation` VALUES ('17', '哈萨克族');
INSERT INTO `nation` VALUES ('18', '傣族');
INSERT INTO `nation` VALUES ('19', '黎族');
INSERT INTO `nation` VALUES ('20', '傈僳族');
INSERT INTO `nation` VALUES ('21', '佤族');
INSERT INTO `nation` VALUES ('22', '畲族');
INSERT INTO `nation` VALUES ('23', '高山族');
INSERT INTO `nation` VALUES ('24', '拉祜族');
INSERT INTO `nation` VALUES ('25', '水族');
INSERT INTO `nation` VALUES ('26', '东乡族');
INSERT INTO `nation` VALUES ('27', '纳西族');
INSERT INTO `nation` VALUES ('28', '景颇族');
INSERT INTO `nation` VALUES ('29', '柯尔克孜族');
INSERT INTO `nation` VALUES ('30', '土族');
INSERT INTO `nation` VALUES ('31', '达斡尔族');
INSERT INTO `nation` VALUES ('32', '仫佬族');
INSERT INTO `nation` VALUES ('33', '羌族');
INSERT INTO `nation` VALUES ('34', ' 布朗族');
INSERT INTO `nation` VALUES ('35', ' 撒拉族');
INSERT INTO `nation` VALUES ('36', ' 毛难族');
INSERT INTO `nation` VALUES ('37', ' 仡佬族');
INSERT INTO `nation` VALUES ('38', ' 锡伯族');
INSERT INTO `nation` VALUES ('39', ' 阿昌族');
INSERT INTO `nation` VALUES ('40', ' 普米族');
INSERT INTO `nation` VALUES ('41', ' 塔吉克族');
INSERT INTO `nation` VALUES ('42', ' 怒族');
INSERT INTO `nation` VALUES ('43', ' 乌孜别克族');
INSERT INTO `nation` VALUES ('44', ' 俄罗斯族');
INSERT INTO `nation` VALUES ('45', ' 鄂温克族');
INSERT INTO `nation` VALUES ('46', ' 崩龙族');
INSERT INTO `nation` VALUES ('47', ' 保安族');
INSERT INTO `nation` VALUES ('48', ' 裕固族');
INSERT INTO `nation` VALUES ('49', ' 京族');
INSERT INTO `nation` VALUES ('50', ' 塔塔尔族');
INSERT INTO `nation` VALUES ('51', ' 独龙族');
INSERT INTO `nation` VALUES ('52', ' 鄂伦春族');
INSERT INTO `nation` VALUES ('53', ' 赫哲族');
INSERT INTO `nation` VALUES ('54', ' 门巴族');
INSERT INTO `nation` VALUES ('55', ' 珞巴族');
INSERT INTO `nation` VALUES ('56', ' 基诺族');

-- ----------------------------
-- Table structure for personnel_info
-- ----------------------------
DROP TABLE IF EXISTS `personnel_info`;
CREATE TABLE `personnel_info` (
  `personnel_id` int(10) NOT NULL AUTO_INCREMENT,
  `houses_id` int(10) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT '',
  `per_sort` int(1) DEFAULT NULL COMMENT '1 app用户2 通过app添加的用户',
  `live_type_id` int(10) DEFAULT NULL,
  `live_type_name` varchar(32) DEFAULT NULL,
  `lease_mode` int(1) DEFAULT '1' COMMENT '1长期、2有效时长',
  `lease_start_time` datetime DEFAULT NULL COMMENT '租赁开始时间',
  `lease_stop_time` datetime DEFAULT NULL COMMENT '租赁结束时间',
  `username` varchar(64) DEFAULT NULL COMMENT '姓名',
  `gender` int(1) DEFAULT NULL COMMENT '1男2女',
  `face_photo` varchar(512) DEFAULT NULL,
  `face_file` varchar(32) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `nation_id` int(10) DEFAULT NULL,
  `nation_name` varchar(16) DEFAULT NULL,
  `telephone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `certificates_type_id` int(10) DEFAULT NULL,
  `certificates_type_name` varchar(64) DEFAULT '',
  `certificates_positive_photo` varchar(512) DEFAULT '' COMMENT '证件正面照片',
  `certificates_positive_file` varchar(32) DEFAULT NULL,
  `certificates_negative_photo` varchar(512) DEFAULT '' COMMENT '证件反面照片',
  `certificates_negative_file` varchar(32) DEFAULT NULL,
  `certificates_number` varchar(64) DEFAULT '' COMMENT '证件号',
  `certificates_start_time` datetime DEFAULT NULL COMMENT '证件有效期开始时间',
  `certificates_stop_time` datetime DEFAULT NULL COMMENT '证件有效期结束时间',
  `certificates_address` varchar(512) DEFAULT NULL COMMENT '证件地址',
  `certificates_office` varchar(128) DEFAULT NULL COMMENT '证件办证机关',
  `enterprise_name` varchar(128) DEFAULT NULL COMMENT '即app店铺租户所填的企业名称',
  `status` int(1) DEFAULT '1' COMMENT '1 未审核2 审核通过3审核失败4 过期5 注销6 撤销',
  `audit_remark` varchar(512) DEFAULT '' COMMENT '审核失败原因',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`personnel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personnel_info
-- ----------------------------
INSERT INTO `personnel_info` VALUES ('1', '1', '1', '1', '1', '房主（产权人）', '1', '2019-10-29 11:49:31', '2019-10-29 11:49:33', '张三', '1', '/jianfuzengxiao/attached/idcard/face1.png', null, '2018-10-31 16:31:19', '1', '汉族', '130000000', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '13000000000000', '2019-10-31 16:32:38', '2019-10-31 16:32:41', '河北省石家庄市裕华区', '河北省石家庄市裕华区', null, '1', '', '2019-10-29 11:49:41', null, 'A');
INSERT INTO `personnel_info` VALUES ('2', '1', '', '2', '5', '租户', '1', '2019-10-31 16:30:42', '2019-10-31 16:30:44', '王五', '1', '/jianfuzengxiao/attached/idcard/face2.png', null, '2010-10-31 16:31:26', '1', '汉族', '150000000', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '11000000000000', '2019-10-31 16:32:43', '2019-10-31 16:32:45', '河北省石家庄市长安区', '河北省石家庄市裕华区', null, '3', '管理员反馈111111', '2019-10-29 11:50:02', '2019-11-01 20:12:08', 'P');
INSERT INTO `personnel_info` VALUES ('3', '1', '', '2', '7', '家属', '1', '2019-10-31 16:30:48', '2019-10-31 16:30:50', '二狗子', '2', '/jianfuzengxiao/attached/idcard/face3.png', null, '2010-10-31 16:31:30', '1', '汉族', '180000000', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '12000000000000', '2019-10-31 16:32:47', '2019-10-31 16:32:49', '河北省石家庄市藁城区', '河北省石家庄市裕华区', null, '2', '', '2019-10-29 14:09:29', null, 'A');
INSERT INTO `personnel_info` VALUES ('4', '2', '1', '1', '2', '店主（租赁）', '1', '2019-11-01 09:56:01', '2019-11-01 09:56:02', '张狗蛋', '1', '/jianfuzengxiao/attached/idcard/face1.png', null, '2009-11-01 09:56:18', '1', '汉族', '122000000', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '13000212313223', '2019-11-01 09:56:43', '2019-11-01 09:56:45', '河北省石家庄', '河北省石家庄', null, '3', '管理员反馈222222', '2019-11-01 09:57:11', '2019-11-01 20:12:16', 'P');
INSERT INTO `personnel_info` VALUES ('5', '1', '', '2', '5', '租户', '2', '2019-11-01 09:58:08', '2019-11-01 09:58:12', '三毛', '1', '/jianfuzengxiao/attached/idcard/face2.png', null, '2019-11-01 09:58:37', '1', '汉族', '133333333', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '13001223315253', '2019-11-01 09:59:02', '2019-11-01 09:59:05', '河北石家庄', '河北省石家庄', null, '1', '', '2019-11-01 09:59:24', null, 'A');
INSERT INTO `personnel_info` VALUES ('6', '1', '', '2', '7', '家属', '1', '2019-11-01 10:00:41', '2019-11-01 10:00:44', '王二小', '2', '/jianfuzengxiao/attached/idcard/face3.png', null, '2019-11-01 10:01:06', '1', '汉族', '122222233', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '13121541564654', '2019-11-01 10:01:29', '2019-11-01 10:01:32', '河北省邢台市', '河北省邢台市', null, '1', '', '2019-11-01 10:01:58', null, 'A');
INSERT INTO `personnel_info` VALUES ('7', '2', '', '2', '6', '员工', '2', '2019-11-01 10:02:21', '2019-11-01 10:02:23', '五五开', '1', '/jianfuzengxiao/attached/idcard/face1.png', null, '2019-11-01 10:02:37', '1', '汉族', '155666546', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '15615614651456', '2019-11-01 10:02:53', '2019-11-01 10:02:55', '上海市浦东区', '上海市浦东区', null, '1', '', '2019-11-01 10:02:03', null, 'A');
INSERT INTO `personnel_info` VALUES ('8', '2', '', '2', '6', '员工', '2', '2019-11-01 10:03:53', '2019-11-01 10:03:55', '马飞', '2', '/jianfuzengxiao/attached/idcard/face2.png', null, '2019-11-01 10:04:05', '1', '汉族', '156564566', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '15616549665466', '2019-11-01 10:04:22', '2019-11-01 10:04:24', '哈哈哈', '哈哈哈', null, '3', '', '2019-11-01 10:04:36', null, 'A');
INSERT INTO `personnel_info` VALUES ('9', '2', '', '2', '6', '员工', '2', '2019-11-01 10:05:04', '2019-11-01 10:05:06', '亚索', '1', '/jianfuzengxiao/attached/idcard/face3.png', null, '2019-11-01 10:05:46', '1', '汉族', '156561566', '1', '身份证', '/jianfuzengxiao/attached/idcard/idcard_zheng.png', null, '/jianfuzengxiao/attached/idcard/idcard_fan.png', null, '15564654646465', '2019-11-01 10:06:02', '2019-11-01 10:06:04', '哈哈哈哈哈', '呵呵呵呵呵', null, '2', '', '2019-11-01 10:06:15', null, 'A');

-- ----------------------------
-- Table structure for role_func
-- ----------------------------
DROP TABLE IF EXISTS `role_func`;
CREATE TABLE `role_func` (
  `role_func_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL,
  `right_code` varchar(30) NOT NULL,
  `sts` char(1) NOT NULL,
  `sts_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_func_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1622 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_func
-- ----------------------------

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  `sts` char(1) NOT NULL,
  `sts_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', '系统管理员', '系统后台用户主要是对基础数据维护、房产认证管理、用户管理、数据上报管理、统计分析、首页', 'A', '2019-10-30 17:10:40');
INSERT INTO `role_info` VALUES ('2', '保户干部', '用户审核和认证', 'A', '2019-10-30 17:10:42');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` varchar(32) NOT NULL,
  `config_name` varchar(50) NOT NULL,
  `config_value` varchar(255) NOT NULL,
  `type` tinyint(1) unsigned DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `editable` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(32) NOT NULL,
  `username` varchar(64) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL COMMENT '1男2女',
  `face_photo` varchar(512) DEFAULT NULL,
  `face_file` varchar(32) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `nation_id` int(4) DEFAULT NULL,
  `nation_name` varchar(16) DEFAULT NULL,
  `telephone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `certificates_type_id` int(10) DEFAULT NULL,
  `certificates_type_name` varchar(64) DEFAULT NULL,
  `certificates_positive_photo` varchar(512) DEFAULT '' COMMENT '证件正面照片',
  `certificates_negative_photo` varchar(512) DEFAULT '' COMMENT '证件背面照片',
  `certificates_number` varchar(64) DEFAULT NULL COMMENT '证件号码',
  `certificates_start_time` datetime DEFAULT NULL COMMENT '证件起始时间',
  `certificates_stop_time` datetime DEFAULT NULL,
  `certificates_address` varchar(512) DEFAULT NULL COMMENT '证件地址',
  `certificates_office` varchar(512) DEFAULT NULL COMMENT '办证机关',
  `status` int(1) DEFAULT '1' COMMENT '1待认证2已认证3失败',
  `audit_remark` varchar(512) DEFAULT ' ' COMMENT '认证失败原因',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `sts` char(1) NOT NULL DEFAULT 'A',
  `lease_start_time` datetime DEFAULT NULL COMMENT '居住开始时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '12', '1', '12', null, '2001-00-00 00:00:00', '1', '1', '1', '12', '12', '12', '12', '1', '2001-00-00 00:00:00', '2001-00-00 00:00:00', '1', '1', '2', null, '2019-10-28 13:46:28', null, 'A', '2001-00-00 00:00:00');
INSERT INTO `user_info` VALUES ('123456', '1q23', '2', '123', null, '2019-10-28 12:54:18', '1', '123', '11', '1', '123', '123', '123', '11', '2019-10-28 12:54:53', '2019-10-28 12:55:00', '11', '11', '1', null, '2019-10-28 12:55:17', null, 'A', '2019-10-28 13:05:24');
INSERT INTO `user_info` VALUES ('1234561', '1q23', '1', '123', null, '2019-10-28 12:54:18', '1', '123', '11', '1', '123', '123', '123', '11', '2019-10-28 12:54:53', '2019-10-28 12:55:00', '11', '11', '1', null, '2019-10-28 13:05:17', null, 'A', '2019-10-28 12:56:43');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  `sts` char(1) NOT NULL,
  `sts_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
