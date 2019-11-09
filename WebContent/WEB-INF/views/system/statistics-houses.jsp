<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/house.css">
<title>房屋信息统计</title>
</head>
<body>
	<div class="content">
		<div class="nav">
			<div class="Community Community0">
				<div class="nav_title">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">社区
				</div>
				<ul class="nav_list">
					<li class="active">全部</li>
					<li>场所一</li>
					<li>场所二</li>
					<li>场所三</li>
					<li>场所四</li>
					<li>场所五</li>
					<li>场所一</li>
					<li>场所二</li>
					<li>场所三</li>
					<li>场所四</li>
					<li>场所五</li>
					<li>场所五</li>
					<li>场所一</li>
					<li>场所二</li>
					<li>场所三</li>
					<li>场所四</li>
					<li>场所五</li>
				</ul>
			</div>
			<div class="Community place">
				<div class="nav_title">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">场所
				</div>
				<ul class="nav_list">
					<li class="active">全部</li>
					<li>小区一</li>
					<li>小区二</li>
					<li>小区三</li>
					<li>小区四</li>
					<li>小区五</li>
					<li>街1</li>
					<li>街2</li>
					<li>路2</li>
					<li>路3</li>
				</ul>
				<div class="nav_num">(共计10户)</div>
			</div>
		</div>
		<div class="total">房屋总量：23373户</div>
		<div style="display: flex; flex-wrap: wrap; min-width: 1200px;">
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋分类情况
				</div>
				<div class="statime"></div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									自建房
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									商住房
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 211, 80);"></div>
									门店
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="chart">
						<div id="house" style="height: 100%"></div>
					</div>
				</div>
			</div>
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋出租情况
				</div>
				<div class="statime">
					<div class="so_far active">全部</div>
					<div class="so_far">自建房</div>
					<div class="so_far">商住房</div>
					<div class="so_far">门店</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									已出租
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									未出租
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="chart">
						<div id="container" style="height: 100%"></div>
					</div>
				</div>
			</div>
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋利用情况
				</div>
				<div class="statime">
					<div class="so_far active">全部</div>
					<div class="so_far">自建房</div>
					<div class="so_far">商住房</div>
					<div class="so_far">门店</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									闲置
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									已用
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="chart">
						<div id="house0" style="height: 100%"></div>
					</div>
				</div>
			</div>
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋户型情况
				</div>
				<div class="statime">
					<div class="so_far active">全部</div>
					<div class="so_far">自建房</div>
					<div class="so_far">商住房</div>
					<div class="so_far">门店</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									户型名称1
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									户型名称1
								</div>
								<span>3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="chart">
						<div id="house1" style="height: 100%"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/jianfuzengxiao/statics/system/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/echarts.min.js"></script>
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/chart.js"></script>
	<script>
        $(function () {
            $('.Community li').click(function () {
                $(this).addClass('active').siblings('li').removeClass('active')
            })
            $('.statime .so_far').click(function () {
                $(this).addClass('active').siblings('.so_far').removeClass('active')
            })
        })
    </script>
</body>
</html>