// 인입현황
$.ajax({
    url: "/main/chart/intype",
    method: "POST",
    dataType: "json",
    data : {},
    cache: false,
    success: function (recpData) {
        var recpArr = new Array();
        recpArr[0] = recpData.normal;
        recpArr[1] = recpData.compli;
        recpArr[2] = recpData.quality;
        recpArr[3] = recpData.afterService;
        recpArr[4] = recpData.center;
        recpArr[5] = recpData.store;
        recpArr[6] = recpData.complain;
        recpArr[7] = recpData.management;

        var ctx = document.getElementById("callStatus");
        var receiptChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: ['일반', '칭찬', '품질', 'A/S', '콜센', '매장','불만','관리'],
                datasets: [{
                    label: '# 접수유형',
                    data:  recpArr,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

    },
    error: function (request, status, error) {
    }
});


//시간대별 IN/OUT 콜

$.ajax({
    url: "/main/chart/intype",
    method: "POST",
    dataType: "json",
    data : {},
    cache: false,
    success: function (recpData) {
        var recpArr = new Array();
        recpArr[0] = recpData.complain;
        recpArr[1] = recpData.compli;
        var ctx2 = document.getElementById("inOutCountChart");
        var inOutCountChart = new Chart(ctx2, {
            type: 'bar',
            data: {
                labels: ['09-10', '11-12시', '12-13시', '14-15', '16-17','17-18'],
                datasets: [
                    {
                        label: "INBOUND",
                        backgroundColor: 'rgba(255, 99, 132, 0.2)',
                        borderColor:  'rgba(255, 99, 132, 1)',
                        data: [25, 19, 0, 42, 60]
                    },
                    {
                        label: "OUTBOUND",
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        pointBackgroundColor: "rgba(26,179,148,1)",
                        data: [10, 8, 0, 35, 20]
                    }
                ]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

    },
    error: function (request, status, error) {
    }
});


// 상담제품
$.ajax({
    url: "/main/chart/produDay",
    method: "POST",
    dataType: "json",
    data : {},
    cache: false,
    success: function (recpData) {
        var recpArr = new Array();
        recpArr[0] = recpData.prodCode1;
        recpArr[1] = recpData.prodCode2;
        recpArr[2] = recpData.prodCode3;
        recpArr[3] = recpData.prodCode4;
        recpArr[4] = recpData.prodCode5;

        var ctx3 = document.getElementById("inproduct");
        var inproduct = new Chart(ctx3, {
            type: 'bar',
            data: {
                labels: ['폴리코사놀 10mg(30정)', '폴리코사놀 5mg(30정)', '폴리코사놀 10mg(75정)', '폴리코사놀 10mg(180정)', '폴리코사놀 in 오메가'],
                datasets: [{
                    label: '접수제품',
                    data: recpArr,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
    },
    error: function (request, status, error) {
    }
});



//처리상태
$.ajax({
    url: "/main/chart/proc",
    method: "POST",
    dataType: "json",
    data : {},
    cache: false,
    success: function (recpData) {
        var recpArr = new Array();
        recpArr[0] = recpData.receipt;
        recpArr[1] = recpData.complite;
        recpArr[2] = recpData.process;
        recpArr[3] = recpData.personTransfer;
        recpArr[4] = recpData.senioTtransfer;
        recpArr[5] = recpData.Unprocessed;

        var ctx4 = document.getElementById("processStatus");
        var processStatus = new Chart(ctx4, {
            type: 'bar',
            data: {
                labels: ['접수', '처리', '완료', '담당자이관', '상급자이관','미처리'],
                datasets: [{
                    label: '상담처리',
                    data: recpArr,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

    },
    error: function (request, status, error) {
    }
});
