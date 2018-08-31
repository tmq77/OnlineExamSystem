/*
Navicat MySQL Data Transfer

Source Server         : tmq
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : onlineexamsystem

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-04-21 12:32:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ansessay`
-- ----------------------------
DROP TABLE IF EXISTS `ansessay`;
CREATE TABLE `ansessay` (
  `baseId` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `bEssayId` int(11) NOT NULL,
  `bAnswer` varchar(8000) NOT NULL,
  PRIMARY KEY (`baseId`),
  KEY `account` (`account`),
  CONSTRAINT `ansessay_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user_interviewer` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ansessay
-- ----------------------------

-- ----------------------------
-- Table structure for `audioans_info`
-- ----------------------------
DROP TABLE IF EXISTS `audioans_info`;
CREATE TABLE `audioans_info` (
  `vid` char(255) NOT NULL,
  `vanswer` varchar(8000) NOT NULL,
  `account` char(255) NOT NULL,
  PRIMARY KEY (`vid`),
  UNIQUE KEY `account` (`account`) USING BTREE,
  CONSTRAINT `audioans_info_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user_interviewer` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audioans_info
-- ----------------------------

-- ----------------------------
-- Table structure for `audioright_info`
-- ----------------------------
DROP TABLE IF EXISTS `audioright_info`;
CREATE TABLE `audioright_info` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aRight` varchar(8000) NOT NULL DEFAULT '录音题参考答案',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audioright_info
-- ----------------------------
INSERT INTO `audioright_info` VALUES ('1', '录音题参考答案');

-- ----------------------------
-- Table structure for `baseessay`
-- ----------------------------
DROP TABLE IF EXISTS `baseessay`;
CREATE TABLE `baseessay` (
  `essayTitle` varchar(8000) NOT NULL,
  `essayRight` varchar(8000) NOT NULL,
  `essayId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`essayId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of baseessay
-- ----------------------------
INSERT INTO `baseessay` VALUES ('假设有一个池塘，里面有无穷多的水。现有2个空水壶，容积分别为5升和6升。问题是如何只用这2个水壶从池塘里取得3升的水。', '由满6向空5倒，剩1升，把这1升倒5里，然后6剩满，倒5里面，由于5里面有1升水，因此6只能向5倒4升水，然后将6剩余的2升，倒入空的5里面，再灌满6向5里倒3升，剩余3升。', '1');
INSERT INTO `baseessay` VALUES ('五个大小相同的一元人民币硬币。要求两两相接触，应该怎么摆？', '底下放一个1，然后2 3放在1上面，另外的4 5竖起来放在1的上面。', '2');
INSERT INTO `baseessay` VALUES ('1=5，2=15，3=215，4=2145那么5=?', '因为1=5，所以5=1．', '3');
INSERT INTO `baseessay` VALUES ('一个人花8块钱买了一只鸡，9块钱卖掉了，然后他觉得不划算，花10块钱又买回来了，11块卖给另外一个人。问他赚了多少?', '2元', '4');
INSERT INTO `baseessay` VALUES ('一楼到十楼的每层电梯门口都放着一颗钻石，钻石大小不一。你乘坐电梯从一楼到十楼，每层楼电梯门都会打开一次，只能拿一次钻石，问怎样才能拿到最大的一颗？', '先拿下第一楼的钻石，然后在每一楼把手中的钻石与那一楼的钻石相比较，如果那一楼的钻石比手中的钻石大的话那就把手中的钻石换成那一层的钻石。', '5');
INSERT INTO `baseessay` VALUES ('1，11，21，1211，111221，下一个数是什么？', '下行是对上一行的解释所以新的应该是3个1 2个2 1个1 ：312211', '6');
INSERT INTO `baseessay` VALUES ('1元钱一瓶汽水，喝完后两个空瓶换一瓶汽水，问：你有20元钱，最多可以喝到几瓶汽水？', '40瓶，20+10+5+2+1+1=39， 这时还有一个空瓶子，先向店主借一个空瓶，换来一瓶汽水喝完后把空瓶还给店主', '8');
INSERT INTO `baseessay` VALUES ('你有一条平分为 7 段但仍相连的金条， 计划付给工人作为为你工作 7 天的工资， 现在要求： 你必须在每天结束时给工人付报酬； 不能多也不能少； 合计只允许你两次把金条弄断。你如何给你的工人付费？', '把金条分成1，2，4三段。第一天1，第二天2，第三天1+2,第七天1+2+4。', '9');
INSERT INTO `baseessay` VALUES ('现有 12 个球和一个天平， 已知有一个球和其它球的重量不同， 仅允许你称三次。 请问如\r\n10箱黄金，每箱100块，每块一两。有贪官，把某一箱的每块都磨去一钱。请称一次找到不足量的那个箱子', '第一箱子拿1块，第二箱子拿2块， 第n箱子拿n块，然后放在一起称，看看缺了几钱，缺了n钱就说明是第n个箱子', '10');
INSERT INTO `baseessay` VALUES ('有两位盲人，他们都各自买了两对黑袜和两对白袜，八对袜了的布质、大小完全相同，而每对袜了都有一张商标纸连着。两位盲人不小心将八对袜了混在一起。他们每人怎样才能取回黑袜和白袜各两对呢？', '拆开所有的袜子，每人一个', '11');
INSERT INTO `baseessay` VALUES ('对一批编号为1～100，全部开关朝上(开)的灯进行以下操作：凡是1的倍数反方向拨一次开关；2的倍数反方向又拨一次开关；3的倍数反方向又拨一次开关??问：最后为关熄状态的灯的编号', '1 4 9', '12');
INSERT INTO `baseessay` VALUES ('据说有人给酒肆的老板娘出了一个难题：此人明明知道店里只有两个舀酒的勺子，分别能舀7两和11两酒，却硬要老板娘卖给他2两酒。聪明的老板娘毫不含糊，用这两个勺子在酒缸里舀酒，并倒来倒去，居然量出了2两酒，聪明的你能做到吗？', '11,0-->4,7-->4,0-->0,4-->11,4-->8,7-->8,0-->1,7-->1,0-->0,1-->11,1-->5,7-->5,0-->0,5-->11,5-->9,7-->9,0-->2,7，这样就有2斤了。', '13');
INSERT INTO `baseessay` VALUES ('假设排列着100个乒乓球，由两个人轮流拿球装入口袋，能拿到第100个乒乓球的人为胜利者。条件是：每次拿球者至少要拿1个，但最多不能超过5个，问：如果你是最先拿球的人，你该拿几个？以后怎么拿就能保证你能得到第100个乒乓球？', '首先拿4个 别人拿n个你就拿6－n个', '14');

-- ----------------------------
-- Table structure for `essay`
-- ----------------------------
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay` (
  `eTitle` varchar(8000) NOT NULL,
  `eRight` varchar(8000) NOT NULL,
  `post` char(255) NOT NULL,
  `essayId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`essayId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of essay
-- ----------------------------
INSERT INTO `essay` VALUES ('简要说明你对java中关键字static的理解及应用', '参考答案', '软件工程师', '1');
INSERT INTO `essay` VALUES ('简要说明java的异常处理机制', '参考答案', '软件工程师', '2');
INSERT INTO `essay` VALUES ('说明你对多线程并发问题的理解', '参考答案', '软件工程师', '3');
INSERT INTO `essay` VALUES ('什么是多态？', '参考答案', '软件工程师', '4');
INSERT INTO `essay` VALUES ('什么是匿名内部类', '参考答案', '软件工程师', '5');
INSERT INTO `essay` VALUES ('谈谈你对框架的理解', '参考答案', '软件工程师', '6');
INSERT INTO `essay` VALUES ('说出五个你常见的异常', '参考答案', '软件工程师', '7');
INSERT INTO `essay` VALUES ('请简要回答对你对微分电路与积分电路的认识、 理解、 及应用？', '参考答案', '硬件工程师', '9');
INSERT INTO `essay` VALUES ('请简要列出你所知道的滤波电路的类型， 并简要说明其实现方式及其适用场境？', '参考答案', '硬件工程师', '10');
INSERT INTO `essay` VALUES ('单片机是硬件设计中的常用器件， 如果你新设计的一个电路中， 单片机不工作。 请简要说明你的检修\r\n思路？', '参考答案', '硬件工程师', '11');
INSERT INTO `essay` VALUES ('在组网中， 我们常说的私网地址都有哪些？ 详细列出， 并简要说明其常规用途；', '参考答案', '网络工程师', '12');
INSERT INTO `essay` VALUES ('打开网页浏览相关内容时， 一般人员觉得很方便很简单。 但是作为网络工程师， 我们知道这是一个复杂的过程。 请列出该过程？', '参考答案', '网络工程师', '13');
INSERT INTO `essay` VALUES ('当遇到网络不通时， 你的解决思路是什么？ 请列出？', '参考答案', '网络工程师', '14');
INSERT INTO `essay` VALUES (' 请列出你所知道的钢材种类， 简要说明性能及应用选择？', '参考答案', '机械工程师', '15');
INSERT INTO `essay` VALUES ('请简要列出你所知道及会使用的 CAD 工具软件 （ 包括建模工具） ，简要说明其优缺点以及你使用感受？', '参考答案', '机械工程师', '16');
INSERT INTO `essay` VALUES ('简要列出一些机械工程师常用的实物工具， 简要说明其用途？', '参考答案', '机械工程师', '17');
INSERT INTO `essay` VALUES ('简要说明你对有功功率、 无功功率、 功率因素的理解。 为了提高功率因素。 你都有哪些建议？ ', '参考答案', '电气工程师', '18');
INSERT INTO `essay` VALUES ('简要列出你所知道的变压器种类及其优缺点。 大型变压器铁芯通常要做接地处理， 为什么？', '参考答案', '电气工程师', '19');
INSERT INTO `essay` VALUES ('列出电气工程师常用工具， 并简要其说明功能及使用环境？ ', '参考答案', '电气工程师', '20');

-- ----------------------------
-- Table structure for `exam_basesingle`
-- ----------------------------
DROP TABLE IF EXISTS `exam_basesingle`;
CREATE TABLE `exam_basesingle` (
  `BaseSingleTitle` varchar(2000) NOT NULL,
  `BaseSingleA` char(255) NOT NULL,
  `BaseSingleB` char(255) NOT NULL,
  `BaseSingleC` char(255) NOT NULL,
  `BaseSingleD` char(255) NOT NULL,
  `BaseSingleAS` char(10) NOT NULL,
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_basesingle
-- ----------------------------
INSERT INTO `exam_basesingle` VALUES ('选出不同类的一项', '蛇', '大树', '老虎', '狮子', 'B', '1');
INSERT INTO `exam_basesingle` VALUES ('在下列分数中，选出不同类的一项', '3/5', '3/7', '3/9', '3/11', 'C', '2');
INSERT INTO `exam_basesingle` VALUES ('男孩对孩子，正如女孩对', '青年', '孩子', '夫人', '姑娘', 'D', '3');
INSERT INTO `exam_basesingle` VALUES ('笔相对于写字，那么书相对于', '娱乐', '阅读', '学文化', '解除', 'B', '4');
INSERT INTO `exam_basesingle` VALUES ('马之于马厩，正如人之于', '牛棚', '马车', '房屋', '农场', 'C', '5');
INSERT INTO `exam_basesingle` VALUES ('2,8,14,20，（）', '24', '26', '28', '30', 'B', '6');
INSERT INTO `exam_basesingle` VALUES ('1,3,2,4,6,5,7，（）', '8', '9', '11', '19', 'B', '7');
INSERT INTO `exam_basesingle` VALUES ('3,3,6,12,24，（）', '32', '38', '40', '48', 'D', '8');
INSERT INTO `exam_basesingle` VALUES ('\"p→q\"负判断是', 'p∧g', 'p∨q', 'p∨g', '_p真且q假_', 'D', '9');
INSERT INTO `exam_basesingle` VALUES ('\"所有的公民都享有选举权\"与\"有的公民没有选举权\"这两个性质判断具有', '反对关系', '矛盾关系', '差等关系', '下反对关系', 'B', '10');
INSERT INTO `exam_basesingle` VALUES ('当p假q假时,下列判断形式为真的是', 'p∧q', 'p∨q', 'p→q', 'p∧q', 'C', '11');
INSERT INTO `exam_basesingle` VALUES ('所有女孩都喜欢体育运动，Suc和Josie喜欢网球，而Sally和Anne喜欢跑步，Sue和Anne都喜欢游泳，谁喜欢网球和游泳？', 'Sue', 'Josie', 'Sally', 'Anne', 'A', '12');
INSERT INTO `exam_basesingle` VALUES ('和“并非：这个商店的商品价廉物美”相等值的命题是', '这个商店的商品价不廉，物也不美', '这个商店的商品价廉但物不美', '这个商店的商品价不廉，或物不美', '这个商店的商品物美但价不廉', 'C', '13');
INSERT INTO `exam_basesingle` VALUES ('与定义“法律就是行为规范”所犯逻辑错误相同的是', '科学理论就是符合实际的认识', '新闻不是过去发生事情的报道', '教师是人类灵魂的工程师', '企业就是从事现代化生产的经济活动部门', 'A', '14');
INSERT INTO `exam_basesingle` VALUES ('下列限制或概括不正确的是', '把“森林”限制为“防护林”', '把“正概念”概括为“普遍概念”', '把“颜色”限制为“红色”', '把“中国”概括为“亚洲的国家”', 'B', '15');
INSERT INTO `exam_basesingle` VALUES ('与“只有懂法律，才能当律师”这一命题具有等值关系的命题是', '只有当律师，才要懂法律', '若懂法律，就能当律师', '若当律师，就要懂法律', '若不当律师，就不要懂法律', 'C', '16');
INSERT INTO `exam_basesingle` VALUES ('下列结论能通过完全归纳推理得到的是', '原子都是可分的', '春夏秋冬，周而复始', '甲班所有的同学都是兰州人', '天下乌鸦一般黑', 'C', '17');
INSERT INTO `exam_basesingle` VALUES ('“人治兴则国家危，因为人治兴则法制衰，法治衰则人情滥，人情滥则后门开，后门开则 贪污盛，贪污盛则国家危。”这一证明的证明方式是', '演绎证明', '归纳证明', '反证法', '选言证法', 'A', '18');
INSERT INTO `exam_basesingle` VALUES ('下列语句作为划分，正确的是', '战争分为常规战争和世界大战', '一年可以分为春、夏、秋、冬四季', '这个班的学生，除了七名女学生外，其余都是男生', '概念分为普遍概念、单独概念和正概念', 'C', '19');
INSERT INTO `exam_basesingle` VALUES ('在下列语句中，在集合意义下使用语词“人”的是', '人是有思维能力的', '人非圣贤，孰能无过', '人贵有自知之明', '人是世间万物中第一个可宝贵的', 'D', '20');
INSERT INTO `exam_basesingle` VALUES ('选出不同类的一项', '地板', '壁橱', '窗户', '窗帘', 'D', '21');
INSERT INTO `exam_basesingle` VALUES ('南之于西北，正如西之于', '西北', '东北', '西南', '东南', 'B', '22');
INSERT INTO `exam_basesingle` VALUES ('我国已故著名逻辑学家金岳霖小时候听到“金钱如粪土”,、“朋友值千金”这样两句话后,发现有逻辑问题,因为它们可推出“朋友如粪土”的荒唐结论.既然“朋友如粪土”这个结论不成立,于是从逻辑上可以推出', '“金钱如粪土”这一说法是假的', '“朋友值千金”这一说法是真的', '如果朋友确实值千金,那么金钱并非如粪土', '“金钱如粪土”、“朋友值千金”这两句话或者都真,或者都假', 'C', '23');
INSERT INTO `exam_basesingle` VALUES ('孔子说:“己所不欲,勿施于人.”下面哪一个选项不是上面这句话的逻辑推论? ', '只有己所欲,才能施于人', '若己所欲,则施于人', '除非己所欲,否则不施于人', '凡施于人的都应该是己所欲的', 'B', '24');
INSERT INTO `exam_basesingle` VALUES ('某架直升机上有9名乘客,其中有1名科学家,2名企业家,2名律师,3名美国人,4名中国人.\r\n补充以下哪一项,能够解释题干中提到的总人数和不同身份的人数之间的不一致?', '那位科学家和其中的1名美国人是夫妻', '其中1名企业家的产品主要出口到美国', '2名企业家都是中国人,另有1名美国人是律师', '其中1名律师是其中1名企业家的法律顾问', 'C', '25');
INSERT INTO `exam_basesingle` VALUES ('古希腊哲人说,未经反省的人生是没有价值的.下面哪一个选项与这句格言的意思最不接近? ', '只有经过反省,人生才有价值.', '糊涂一世,快活一生', ' 要想人生有价值,就要不时地对人生进行反省', '人应该活得明白一点', 'B', '26');
INSERT INTO `exam_basesingle` VALUES ('哈尔滨人都是北方人,有些哈尔滨人不是工人.以上命题为真,则以下哪一项肯定为真:', '有些北方人是工人', '有些北方人不是工人', '有些工人是北方人', '有些工人不是北方人', 'B', '27');
INSERT INTO `exam_basesingle` VALUES ('韩国人爱吃酸菜，翠花爱吃酸菜，所以，翠花是韩国人。以下哪个选项最明确地显示了上述推理的荒谬?', '所有的克里特岛人都说谎，约翰是克里特岛人，所以，约翰说谎', '会走路的动物都有腿，桌子有腿，所以，桌子是会走路的动物', '西村爱翠花，翠花爱吃酸菜，所以，西村爱吃酸菜', ' 所有金子都闪光，所以，有些闪光的东西是金子', 'B', '28');

-- ----------------------------
-- Table structure for `exam_eq`
-- ----------------------------
DROP TABLE IF EXISTS `exam_eq`;
CREATE TABLE `exam_eq` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) NOT NULL,
  `optionA` char(255) NOT NULL,
  `optionB` char(255) NOT NULL,
  `optionC` char(255) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_eq
-- ----------------------------

-- ----------------------------
-- Table structure for `printaudio_info`
-- ----------------------------
DROP TABLE IF EXISTS `printaudio_info`;
CREATE TABLE `printaudio_info` (
  `id` char(255) NOT NULL,
  `videoanswer` varchar(8000) NOT NULL,
  `account` char(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of printaudio_info
-- ----------------------------

-- ----------------------------
-- Table structure for `printbase_info`
-- ----------------------------
DROP TABLE IF EXISTS `printbase_info`;
CREATE TABLE `printbase_info` (
  `uuid` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `basetitle` varchar(5000) NOT NULL,
  `baseanswer` varchar(5000) NOT NULL,
  `useranswer` varchar(5000) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of printbase_info
-- ----------------------------

-- ----------------------------
-- Table structure for `printpro_info`
-- ----------------------------
DROP TABLE IF EXISTS `printpro_info`;
CREATE TABLE `printpro_info` (
  `uuid` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `protitle` varchar(5000) NOT NULL,
  `proanswer` varchar(5000) NOT NULL,
  `useranswer` varchar(5000) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of printpro_info
-- ----------------------------

-- ----------------------------
-- Table structure for `printrequired_info`
-- ----------------------------
DROP TABLE IF EXISTS `printrequired_info`;
CREATE TABLE `printrequired_info` (
  `uuid` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `alltitle` varchar(5000) NOT NULL,
  `allanswer` varchar(5000) NOT NULL,
  `useranswer` varchar(5000) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of printrequired_info
-- ----------------------------

-- ----------------------------
-- Table structure for `printsingle_info`
-- ----------------------------
DROP TABLE IF EXISTS `printsingle_info`;
CREATE TABLE `printsingle_info` (
  `uuid` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `singletitle` varchar(2000) NOT NULL,
  `singleA` char(255) NOT NULL,
  `singleB` char(255) NOT NULL,
  `singleC` char(255) NOT NULL,
  `singleD` char(255) NOT NULL,
  `singleAs` char(255) NOT NULL,
  `singleUs` char(255) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of printsingle_info
-- ----------------------------

-- ----------------------------
-- Table structure for `printsingle_temp`
-- ----------------------------
DROP TABLE IF EXISTS `printsingle_temp`;
CREATE TABLE `printsingle_temp` (
  `uuid` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `singletitle` varchar(2000) NOT NULL,
  `singleA` char(255) NOT NULL,
  `singleB` char(255) NOT NULL,
  `singleC` char(255) NOT NULL,
  `singleD` char(255) NOT NULL,
  `singleAs` char(255) NOT NULL,
  `singleUs` char(255) NOT NULL,
  PRIMARY KEY (`uuid`),
  KEY `account` (`account`),
  CONSTRAINT `printsingle_temp_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user_interviewer` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of printsingle_temp
-- ----------------------------

-- ----------------------------
-- Table structure for `proessay`
-- ----------------------------
DROP TABLE IF EXISTS `proessay`;
CREATE TABLE `proessay` (
  `proId` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `essayId` int(11) NOT NULL,
  `answer` varchar(8000) NOT NULL,
  PRIMARY KEY (`proId`),
  KEY `account` (`account`),
  CONSTRAINT `proessay_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user_interviewer` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业简答题答案、考试账号以及题目存储表';

-- ----------------------------
-- Records of proessay
-- ----------------------------

-- ----------------------------
-- Table structure for `requiredanswer`
-- ----------------------------
DROP TABLE IF EXISTS `requiredanswer`;
CREATE TABLE `requiredanswer` (
  `id` char(255) NOT NULL,
  `rid` int(11) NOT NULL,
  `ranswer` varchar(8000) NOT NULL,
  `account` char(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`) USING BTREE,
  CONSTRAINT `requiredanswer_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user_interviewer` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requiredanswer
-- ----------------------------

-- ----------------------------
-- Table structure for `required_info`
-- ----------------------------
DROP TABLE IF EXISTS `required_info`;
CREATE TABLE `required_info` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(8000) NOT NULL,
  `rright` varchar(5000) NOT NULL,
  `post` char(255) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of required_info
-- ----------------------------
INSERT INTO `required_info` VALUES ('1', '现有一个十字路口， 一条是主路， 一条是次要道路， 由于交通信号灯是固定配置， 设定不合理， 经常\r\n造成主路有严重堵车现象。 请利用你所学知识及技能， 尝试缓解这一问题。 简要写出你所能想到的所有相\r\n关内容， 可以只有解决思路， 也可以详细到程序代码', '参考答案', '硬件工程师');
INSERT INTO `required_info` VALUES ('2', '某公司无专业网络人员， 新建办公室时构建了一个小型网络， 只有一台未经配置的交换机， 通过一个\r\n路由器 192.168.0.1， 连接 internet。 由于不是专业人配置， 最后不小心把 3 台直接连接到交换机的 PC 配\r\n置如下：\r\nHOST A: 192.168.0.100/24 GW： 192.168.0.1\r\nHOST B: 192.168.0.2/25 GW： 192.168.0.1\r\nHOST C: 192.168.0.150/24 GW： 192.168.0.1\r\n请回答： （ 1） 、 A 与 B 能通讯吗？ 为什么？ （ 2） 、 A 与 C 能通讯吗？ 为什么？ （ 3） 、 B 与 C 能通讯吗？\r\n为什么？', '参考答案', '网络工程师');
INSERT INTO `required_info` VALUES ('3', '假定要开发一个软件， 该软件功能简单， 即要求实现两数相加的求和运算(a+b=c)。 请简要展现您开\r\n发该软件的全过程（ 请站在软件工程的角度） ', '参考答案', '软件工程师');
INSERT INTO `required_info` VALUES ('4', '某公司因业务需要， 峰值用电时高达 6000KVA， 每天峰值 2-3 小时不等， 常规时段负载 2000KVA。\r\n如果从供电部门申请 6000KVA 线路， 需要 1600 万费用， 极其昂贵。 请你站在电气工程师角度， 提出解\r\n决方案。', '参考答案', '电气工程师');
INSERT INTO `required_info` VALUES ('5', '传统白酒酿酒工艺是这样的： 先将粮食（ 可能是各种可食用的物品） 煮熟， 和酒引子（ 酒药） 充分混\r\n合， 然后装到一个容器中发酵 10-20 天， 通过人工用手插入感受温热度来判断是否发酵完全。 然后蒸馏、\r\n并冷却产生的蒸汽。 所产生的液体就是我们常喝的白酒。 上述各工序都是极耗人工的工作。 请站在一个机\r\n械工程师的角度， 最大化完成上述工序的机械自动化工作（ 可以仅提思路， 也可以写出设计内\r\n容）', '参考答案', '机械工程师');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` char(255) NOT NULL,
  `name` char(255) NOT NULL,
  `baseSingle` char(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE,
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`name`) REFERENCES `user_interviewer` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for `single`
-- ----------------------------
DROP TABLE IF EXISTS `single`;
CREATE TABLE `single` (
  `sTitle` varchar(255) NOT NULL,
  `sOptionA` char(255) NOT NULL,
  `sOptionB` char(255) NOT NULL,
  `sOptionC` char(255) NOT NULL,
  `sOptionD` char(255) NOT NULL,
  `sOptionR` char(2) NOT NULL,
  `post` char(255) NOT NULL,
  `sId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sId`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of single
-- ----------------------------
INSERT INTO `single` VALUES ('8086CPU内部包括哪些单元', 'ALU,EU', 'ALU,BIU', 'EU,BIU', 'ALU,EU,BIU', 'C', '硬件工程师', '1');
INSERT INTO `single` VALUES ('为了避免50Hz的电网电压干扰放大器，应该用那种滤波器', '带阻滤波器', '带通滤波器', '低通滤波器', '高通滤波器', 'A', '硬件工程师', '2');
INSERT INTO `single` VALUES ('关于SRAM和DRAM，下面说话正确的是', 'SRAM需要定时刷新，否则数据会丢失', 'DRAM使用内部电容来保存信息', 'SRAM的集成度高于DRAM', '只要不掉点，DRAM内的数据不会丢失', 'B', '硬件工程师', '3');
INSERT INTO `single` VALUES ('在RS232串口中，采用哪一种校验方式', 'CRC校验', '.海明码校验', '多种校验方式的组合', '奇偶校验', 'D', '硬件工程师', '4');
INSERT INTO `single` VALUES ('﻿对于D触发器来说，为了保证可靠的采样，数据必须在时钟信号的上升沿到来之前继续稳定一段时间，这个时间称为', '保持时间', '恢复时间', '稳定时间', '建立时间', 'D', '硬件工程师', '5');
INSERT INTO `single` VALUES ('本征半导体中加入（）元素可形成N型半导体', '五价', '四价', '三价', '二价', 'A', '硬件工程师', '6');
INSERT INTO `single` VALUES ('模拟信号数字化的过程是', '采样->量化->编码', '采样->编码->量化', '编码->采样->量化', '量化->编码->采样', 'A', '硬件工程师', '7');
INSERT INTO `single` VALUES ('在Buck电路中，不能起到减小纹波作用的措施是', '采用多项并联的模式', '开关管内置，提高电源的开关频率', '输出滤波电容由陶瓷电容改为容量电解电容', '增大输出滤波电感量', 'C', '硬件工程师', '8');
INSERT INTO `single` VALUES ('关于PCI总线的描述，错误的是', 'PCI总线是一个16位宽的总线', 'PCI的地址线与数据线是复用的', 'PCI是一种独立于处理器的总线标准，可以支持多种处理器', 'PCI支持即插即用功能', 'A', '硬件工程师', '9');
INSERT INTO `single` VALUES ('﻿某电路，对100KHz以下低频信号干扰敏感，为减少干扰，应采用（）滤波器', '高通', '低通', '带阻', '带通', 'A', '硬件工程师', '10');
INSERT INTO `single` VALUES ('捕捉毛刺用最佳触发方式（）进行触发', 'Width', 'Edge', 'Glitch', 'State', 'C', '硬件工程师', '11');
INSERT INTO `single` VALUES ('以下哪种信号异常能用逻辑分析仪测试', '信号占空比超标', '信号上升缓慢', '6个信号的异常组合', '信号抖动过大', 'A', '硬件工程师', '12');
INSERT INTO `single` VALUES ('8421码10010111表示的十进制数是（）', '98', '151', '97', '227', 'C', '硬件工程师', '13');
INSERT INTO `single` VALUES ('晶体管能够放大的外部条件是', '发射结反偏，集电结正偏', '发射结正偏，集电结正偏', '发射结反偏，集电结反偏', '发射结正偏，集电结反偏', 'D', '硬件工程师', '14');
INSERT INTO `single` VALUES ('﻿一空气平行板电容器，两级间距为d，充电后板间电压为u。然后将电源断开，在平板间平行插入一厚度为d/3的金属板。此时电容器原板间电压变为', 'U/3', '2U/3', '3U/4', '不变', 'B', '硬件工程师', '15');
INSERT INTO `single` VALUES ('某三极管的三个电极电位分别为VC=0V，VE=－6V，VB=－5.3V，该三极管的工作区为   ', '放大区', '截止区', '饱和区', '击穿区', 'A', '硬件工程师', '16');
INSERT INTO `single` VALUES ('多级放大电路与组成它的各个单级放大电路相比，其通频带BW ', '变宽', '变窄', '不变', '与各单级放大电路无关', 'B', '硬件工程师', '17');
INSERT INTO `single` VALUES ('某仪表放大电路，要求输入电阻大，输出电流稳定，应选  ', '电流串联负反馈', '电流并联负反馈', '电压串联负反馈', '电压并联负反馈', 'A', '硬件工程师', '18');
INSERT INTO `single` VALUES ('在场效应管的微变等效电路中，将场效应管等效为', '电压控制电压源', '电压控制电流源', '电流控制电压源', '电流控制电流源', 'B', '硬件工程师', '19');
INSERT INTO `single` VALUES ('﻿某RC振荡电路的振荡频率为f0 = 10 KHZ,如将RC选频网络中的电容增大一倍，则振荡频率为', '20 KHZ', '14 KHZ', '7 KHZ', '5 KHZ', 'D', '硬件工程师', '20');
INSERT INTO `single` VALUES ('﻿下列说法正确的是（  ）', 'JAVA程序的main方法必须写在类里面', 'JAVA程序中可以有多个main方法', 'JAVA程序中类名必须与文件名一样', 'JAVA程序的main方法中如果只有一条语句，可以不用{}(大括号)括起来', 'A', '软件工程师', '21');
INSERT INTO `single` VALUES ('变量命名规范说法正确的是（  ） ', '变量由字母、下划线、数字、$符号随意组成', '变量不能以数字作为开头', 'A和a在java中是同一个变量', '不同类型的变量，可以起相同的名字；', 'B', '软件工程师', '22');
INSERT INTO `single` VALUES ('为一个boolean类型变量赋值时，可以使用(   )方式  ', 'boolean = 1;', 'boolean a = (9 >= 10);', 'boolean a=\"真\";', 'boolean a = = false;', 'B', '软件工程师', '23');
INSERT INTO `single` VALUES ('以下(  )不是合法的标识符 ', 'STRING', 'x3x;', 'void', 'de$f', 'C', '软件工程师', '24');
INSERT INTO `single` VALUES ('运算符优先级别排序正确的是（ ） ', '由高向低分别是：()、!、算术运算符、关系运算符、逻辑运算符、赋值运算符；', '由高向低分别是：()、关系运算符、算术运算符、赋值运算符、!、逻辑运算符；', '由高向低分别是：()、算术运算符、逻辑运算符、关系运算符、!、赋值运算符；', '由高向低分别是：()、!、关系运算符、赋值运算符、算术运算符、逻辑运算符；', 'A', '软件工程师', '25');
INSERT INTO `single` VALUES ('下列值不为true的表达式有（   ）', ' \"john\" = = \"john\"', ' \"john\".equals(\"john\")', ' \"john\" = \"john\"', ' \"john\".equals(new String(\"john\"))', 'C', '软件工程师', '26');
INSERT INTO `single` VALUES (' 下列（  ）属于引用数据类型', ' String', ' char', ' boolean', ' int', 'A', '软件工程师', '27');
INSERT INTO `single` VALUES (' 在java中下列关于自动类型转换说法正确的是（  ）', ' 基本数据类型和String相加结果一定是字符串型', ' char类型和int类型相加结果一定是字符', ' double类型可以自动转换为int', ' char + int + double +\"\" 结果一定是double；', 'A', '软件工程师', '28');
INSERT INTO `single` VALUES (' 以下（  ）代码，能够对数组正确初始化（或者是默认初始化）。', ' int[] a;', ' a = {1, 2, 3, 4, 5};', ' int[] a = new int[5]{1, 2, 3, 4, 5};', ' int[] a = new int[5];', 'D', '软件工程师', '29');
INSERT INTO `single` VALUES (' 在Java中,关于构造方法，下列说法错误的是(    )', ' 构造方法不可以重写', ' 构造方法可以带参数', ' 构造方法不可以重载', ' 构造方法绝对不能有返回值', 'C', '软件工程师', '30');
INSERT INTO `single` VALUES (' 下面（   ）不是String类提供的合法的方法', 'equals(String)', 'trim()', 'append()', 'indexOf()', 'C', '软件工程师', '31');
INSERT INTO `single` VALUES (' 在Java语言中，下列关于类的继承的描述，正确的是（ ）', ' 一个类可以继承多个父类', ' 一个类可以具有多个子类', ' 子类可以使用父类的所有方法', ' 子类一定比父类有更多的成员方法', 'B', '软件工程师', '32');
INSERT INTO `single` VALUES ('在Java接口中，下列选项中有效的方法声明是', 'public void aMethod();', 'static aMethod();', 'protected void aMethod();', 'private void aMethod();', 'A', '软件工程师', '33');
INSERT INTO `single` VALUES ('在JAVA的异常处理模型中，能单独和finally语句一起使用的块是', 'try', 'catch', 'throw', 'throws', 'A', '软件工程师', '34');
INSERT INTO `single` VALUES ('在JAVA中，Object类是所有类的父亲，用户自定义类默认扩展自Object类，下列选项 中的（  ）方法不属于Object类的方法。', 'equals(Object obj)', 'getClass()', 'toString()', 'trim()', 'D', '软件工程师', '35');
INSERT INTO `single` VALUES ('Java中，如果类C是类B的子类，类B是类A的子类，那么下面描述正确的是', 'C不仅继承了B中的成员，同样也继承了A中的成员', 'C只继承了B中的成员', 'C只继承了A中的成员', 'C不能继承A或B中的成员', 'A', '软件工程师', '36');
INSERT INTO `single` VALUES ('在JAVA中，LinkedList类和ArrayList类同属于集合框架类，下列（  ）选项中的方 法是LinkedList类有而ArrayList类没有的。 ', 'add(Object o)', 'add(int index，Object o)', 'remove(Object o)', 'removeLast()', 'D', '软件工程师', '37');
INSERT INTO `single` VALUES ('以下用于创建容器对象的类是（  ） ', 'Button', 'Checkbox', 'Panel', 'TextField', 'C', '软件工程师', '38');
INSERT INTO `single` VALUES (' 以下关于抽象类和接口的说法错误的是', ' 抽象类在Java语言中表示的是一种继承关系，一个类只能使用一次继承。但是一 个类却可以实现多个接口。', ' 在抽象类中可以没有抽象方法', ' 实现抽象类和接口的类必须实现其中的所有方法，除非它也是抽象类。接口中的方 法都不能被实现', ' 接口中的方法都必须加上public关键字。', 'D', '软件工程师', '39');
INSERT INTO `single` VALUES (' 关于面向对象的说法正确的是（  ）', ' 类可以让我们用程序模拟现实世界中的实体', ' 有多少个实体就要创建多少个类', ' 对象的行为和属性被封装在类中，外界通过调用类的方法来获得，但是要知道类的 内部是如何实现', ' 现实世界中的某些实体不能用类来描述', 'A', '软件工程师', '40');
INSERT INTO `single` VALUES (' 分析选项中关于Java中this关键字的说法正确的是（  ） ', ' this关键字是在对象内部指代自身的引用', ' this关键字可以在类中的任何位置使用', ' this关键字和类关联，而不是和特定的对象关联', '  同一个类的不同对象共用一个this', 'A', '软件工程师', '41');
INSERT INTO `single` VALUES ('﻿以下属于物理层的设备是', '中继器', '以太网交换机', ' 桥', '网关', 'A', '网络工程师', '42');
INSERT INTO `single` VALUES ('在以太网中，是根据（）地址来区分不同的设备的. ', 'LLC地址', 'MAC地址', 'IP地址', 'IPX地址', 'B', '网络工程师', '43');
INSERT INTO `single` VALUES (' IEEE802.3u标准是指', ' 以太网', ' 快速以太网', ' 令牌环网', ' FDDI网', 'B', '网络工程师', '44');
INSERT INTO `single` VALUES (' FDDI 使用的是（）局域网技术。', ' 以太网', ' 快速以太网', ' 令牌环', ' 令牌总线', 'C', '网络工程师', '45');
INSERT INTO `single` VALUES (' TCP 和UDP 协议的相似之处是 ', ' 面向连接的协议', ' 面向非连接的协议', ' 传输层协议', ' 以上均不对', 'C', '网络工程师', '46');
INSERT INTO `single` VALUES (' 小于___的TCP/UDP端口号已保留与现有服务一一对应，此数字以上的端口号可自由分配。', ' 199', ' 100', ' 1024', ' 2048', 'C', '网络工程师', '47');
INSERT INTO `single` VALUES (' 当一台主机从一个网络移到另一个网络时，以下说法正确的是 （）', ' 必须改变它的IP 地址和MAC 地址', ' 必须改变它的IP 地址，但不需改动MAC 地址', ' 必须改变它的MAC 地址，但不需改动IP 地址', ' MAC 地址、IP 地址都不需改动', 'B', '网络工程师', '48');
INSERT INTO `single` VALUES (' 224.0.0.5 代表的是___地址。 （） ', ' 主机地址', ' 网络地址', ' 组播地址', ' 广播地址', 'C', '网络工程师', '49');
INSERT INTO `single` VALUES (' 255.255.255.224可能代表的是（ ）。', ' 一个B类网络号', ' 一个C类网络中的广播', ' 一个具有子网的网络掩码', ' 以上都不是', 'C', '网络工程师', '50');
INSERT INTO `single` VALUES (' 传输层可以通过（ ）标识不同的应用。', '  物理地址', '  端口号', '  IP地址', '  逻辑地址', 'B', '网络工程师', '51');
INSERT INTO `single` VALUES (' 第二代计算机网络的主要特点是 （ ）。 ', ' 计算机-计算机网络', ' 以单机为中心的联机系统', '  国际网络体系结构标准化', '   各计算机制造厂商网络结构标准化', 'A', '网络工程师', '52');
INSERT INTO `single` VALUES ('TCP的协议数据单元被称为（ ）。  ', '比特', '帧', '分段', '字符', 'C', '网络工程师', '53');
INSERT INTO `single` VALUES ('以下的网络分类方法中，哪一组分类方法有误', '局域网/广域网', '对等网/城域网', ' 环型网/星型网', ' 有线网/无线网', 'B', '网络工程师', '54');
INSERT INTO `single` VALUES ('世界上第一个计算机网络是 （）。 ', 'ARPANET', 'ChinaNet', 'Internet', 'CERNET', 'A', '网络工程师', '55');
INSERT INTO `single` VALUES ('www.tsinghua.edu.cn在这个完整名称（FQDN）里，（）是主机名. ', 'edu.cn', 'tsinghua', 'tsinghua.edu.cn', 'www', 'D', '网络工程师', '56');
INSERT INTO `single` VALUES ('以下关于100BASE-T的描述中错误的是（）。  ', '数据传输速率为100Mbit/S', ' 信号类型为基带信号', ' 采用5 类UTP，其最大传输距离为185M', ' 支持共享式和交换式两种组网方式', 'C', '网络工程师', '57');
INSERT INTO `single` VALUES ('一般来说，用户上网要通过因特网服务提供商，其英文缩写为 ', 'IDC', 'ICP', 'ASP', 'ISP', 'D', '网络工程师', '58');
INSERT INTO `single` VALUES ('PPP协议是哪一层的协议', '物理层', '数据链路层', '网络层', '高层', 'B', '网络工程师', '59');
INSERT INTO `single` VALUES ('采用专用线路通信时，可以省去的通信阶段是', '建立通信线路', '建立数据传输链路', '传送通信控制信号和数据', '双方确认通信结束', 'A', '网络工程师', '60');
INSERT INTO `single` VALUES ('计算机网络通信系统是（ ） ', '电信号传输系统', '文字通信系统', '信号通信系统', '数据通信系统', 'D', '网络工程师', '61');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `pid` char(255) NOT NULL,
  `name` char(255) NOT NULL,
  `phone` char(255) NOT NULL,
  `post` char(255) NOT NULL,
  `email` char(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for `user_admin`
-- ----------------------------
DROP TABLE IF EXISTS `user_admin`;
CREATE TABLE `user_admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `pass` char(255) NOT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_admin
-- ----------------------------
INSERT INTO `user_admin` VALUES ('1', '管理员', 'guanliyuan', 'acb383e56931e881dbda41240588c7ab');

-- ----------------------------
-- Table structure for `user_interviewer`
-- ----------------------------
DROP TABLE IF EXISTS `user_interviewer`;
CREATE TABLE `user_interviewer` (
  `uid` char(255) NOT NULL,
  `name` char(255) NOT NULL,
  `account` char(255) NOT NULL,
  `pass` char(255) NOT NULL,
  `post` char(255) NOT NULL,
  `status` char(1) NOT NULL DEFAULT 'f',
  `email` char(255) DEFAULT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_interviewer
-- ----------------------------

-- ----------------------------
-- Table structure for `user_root`
-- ----------------------------
DROP TABLE IF EXISTS `user_root`;
CREATE TABLE `user_root` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) NOT NULL,
  `password` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_root
-- ----------------------------
INSERT INTO `user_root` VALUES ('1', 'root', '4f5fba03a86607a215fe91bd47735689');
