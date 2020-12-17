<%@page import="productState.model.vo.ProductRankState"%>
<%@page import="productState.model.vo.ProductState"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/productStateView.css" />
<%
	List<ProductState> list = (List<ProductState>)request.getAttribute("list");
	List<ProductRankState> rankList = (List<ProductRankState>)request.getAttribute("rankList");
%>
    
<section class="graph-section">
	<div id="graph-containerS" >
		<h2>*브랜드별판매현황*</h2>	
	</div>
  
    <!--Div that will hold the pie chart-->
    <table id="productStateS">
    <tr>
    	<td class="myChart_1">
    		<canvas id="myChart1" width="700" height="400"></canvas>
    	</td>

    	<td class="myChart_2">
			<canvas id="myChart2" width="400" height="600"></canvas>
		</td>
    
    </tr>
    <tr>
    	<td id="chartName1S">브랜드별 주문 현황</td>
    	<td id="chartName2S" >주문량 Top 3</td>
    </tr>
	</table>
	
</section>

    
    <!-- 첫번째 차트 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script>
		var ctx = document.getElementById('myChart1').getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'doughnut',
		    data: {
		        labels: ['<%= list.get(0).getBrand() %>', '<%= list.get(1).getBrand() %>', '<%= list.get(2).getBrand() %>'],
		        datasets: [{
		            title: 'best product',
		            data: [<%= list.get(0).getPercent() %>, <%= list.get(1).getPercent() %>, <%= list.get(2).getPercent() %>],
		            backgroundColor: [
		            	'rgb(220, 020, 060)',
		            	'rgb(15, 162, 235)',
		                'rgb(000, 206, 209)'
		            ],
		            borderColor: [
		            	'rgba(220, 020, 060, 0.1)',
		            	'rgba(15, 162, 235, 0.1)',
		                'rgba(000, 206, 209, 0.1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		    	responsive : false,
		        scales: {
		            yAxes: [{
	            			display: false,
		                ticks: {
		                	
		                    beginAtZero: true
		                }
		            }]
		        }
		    }
		});
		</script>  
    <!-- 두번째 차트 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script>
		var ctx = document.getElementById('myChart2').getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: ['<%= rankList.get(0).getProductName() %>', '<%= rankList.get(1).getProductName() %>', '<%= rankList.get(2).getProductName() %>'],
		        datasets: [{
		            label: 'best product',
		            data: [<%= rankList.get(0).getCount() %>, <%= rankList.get(1).getCount() %>, <%= rankList.get(2).getCount() %>],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.3)',
		                'rgba(154, 050, 204, 0.3)',
		                'rgba(255, 206, 86, 0.3)'
		            ],
		            borderColor: [
		                'rgba(255, 99, 132, 1)',
		                'rgba(154, 050, 204, 0.5)',
		                'rgba(255, 206, 86, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		    	responsive : false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                	stepSize: 5,
		                    beginAtZero: true
		                }
		            }]
		        }
		    }
		});
		</script>  
      

		    
<%@ include file="/WEB-INF/views/common/footer.jsp"%>