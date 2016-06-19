"use strict";angular.module("auction-ui",["ngAnimate","ngCookies","ngResource","ngRoute","ngSanitize","ngTouch"]).config(["$routeProvider",function(a){a.when("/auction/:auctionId",{templateUrl:"views/main.html",controller:"MainCtrl",controllerAs:"main"}).when("/home",{templateUrl:"views/home.html"}).otherwise({redirectTo:"/home"})}]),angular.module("auction-ui").controller("MainCtrl",["socket","config","$routeParams","rest",function(a,b,c,d){console.log("******"),console.log(b),console.log(c),console.log("******");var e=this;e.auctionId=c.auctionId,e.user=JSON.parse(localStorage.getItem("user")),d.getAuction(e.auctionId).then(function(a){console.log("data from controller"),console.log(a),e.auction=a,e.auction.highestBid||(e.auction.highestBid=e.auction.item.startingPrice),e.highestBid={price:e.auction.highestBid},e.nextBidPrice=e.highestBid.price+20}),a.on("bidUpdated",function(a){console.log("================"),console.log(a),console.log(typeof a),console.log("================"),e.highestBid=JSON.parse(a),e.nextBidPrice=e.highestBid.price+20}),e.placeBid=function(){var a={};a.userId=e.user.id,a.auctionId=e.auctionId,a.price=e.nextBidPrice,console.log(a),d.placeBid(a).then(function(a){console.log("successfully placed the bid")})["catch"](function(a){console.log(a)})}}]),angular.module("auction-ui").factory("socket",["$rootScope","config",function(a,b){console.log("******"),console.log(b),console.log("******");var c=io.connect(b.webSocketUrl);return console.log("Initializing the connection of socket it"),{on:function(b,d){c.on(b,function(b){var e=arguments;a.$apply(function(){d.apply(c,e)})})},emit:function(b,d,e){c.emit(b,d,function(){var b=arguments;a.$apply(function(){e&&e.apply(c,b)})})}}}]),angular.module("auction-ui").factory("rest",["$rootScope","config","$http",function(a,b,c){function d(a){function d(a,b,c){return console.log(a),a.data}return console.log("AuctionId "+a),c.get(b.restApisUrl+"/auction/"+a).then(d)["catch"](function(a){console.error("Error occured while fetching the auction details")})}function e(a){function d(a,b,c){return console.log(a),a.data}return console.log("Bidding for"),console.log(a),c.post(b.restApisUrl+"/bid/",a).then(d)["catch"](function(a){console.log("error occured while adding the bid"),console.log(a)})}return{getAuction:d,placeBid:e}}]),function(){function a(){var a=angular.injector(["ng"]),b=a.get("$http");return b.get("resources/uiconfig").then(function(a){c.constant("config",a.data)},function(a){})}function b(){angular.bootstrap(document,["auction-ui"])}var c=angular.module("auction-ui");a().then(b)}(),angular.module("auction-ui").run(["$templateCache",function(a){a.put("views/home.html",'<div class="alert alert-danger"> <h4> Alert! </h4> <strong>Warning!</strong> Please add the auctionId in the url parameter to navigate and bid. <strong>Happy Bidding !!!</strong> <div> Sample URL : /auction/1 </div> </div>'),a.put("views/main.html",'<div class="row"> <div class="col-md-12"> <img src="http://placehold.it/700x250?text=carousel"> </div> </div> <hr> <div class="row"> <div class="col-md-8"> <div class="row"> <div class="col-md-6"> <img src="http://placehold.it/200?text=item"> </div> <div class="col-md-6"> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </div> </div> </div> <div class="col-md-4"> <div ng-if="main.auction.isLive" class="panel panel-info"> <div class="panel-heading"> <h3 class="panel-title"> Latest Bid by </h3> </div> <div class="panel-body"> <address> <strong><span id="userName" ng-bind="main.highestBid.user.name"></span></strong>, <strong><span id="userLocation" ng-bind="main.highestBid.user.location"></span></strong> <br> </address> <div> <img src="http://placehold.it/100x64?text=flag"> </div> <strong>Amount</strong> <span id="price" ng-bind="main.highestBid.price"></span> </div> <div class="panel-footer"> <button ng-click="main.placeBid()" type="button" class="btn btn-block btn-success"> Commit to Bid <span id="nextBidPrice" ng-bind="main.nextBidPrice"></span> </button> </div> </div> <div ng-if="!main.auction.isLive"> <div class="alert alert-danger"> <h4> Alert! </h4> Auction is not <strong>Live !!</strong> </div> </div> </div> </div>')}]);