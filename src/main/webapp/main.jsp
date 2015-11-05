<%--
  Created by IntelliJ IDEA.
  User: AST
  Date: 2015.11.04.
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta email="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <meta charset="utf-8"/>
  <title>Dashboard I Admin Panel</title>
  <link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
  <link rel="stylesheet" href="css/gobig.css" type="text/css" media="screen" />
  <!--[if lt IE 9]>
  <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen"/>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <script src="HTML5%20Admin%20Template/js/jquery-1.5.2.min.js" type="text/javascript"></script>
  <script src="HTML5%20Admin%20Template/js/hideshow.js" type="text/javascript"></script>
  <script src="HTML5%20Admin%20Template/js/jquery.tablesorter.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="HTML5%20Admin%20Template/js/jquery.equalHeight.js"></script>
  <script type="text/javascript">
    $(document).ready(function()
            {
              $(".tablesorter").tablesorter();
            }
    );
    $(document).ready(function() {

      //When page loads...
      $(".tab_content").hide(); //Hide all content
      $("ul.tabs li:first").addClass("active").show(); //Activate first tab
      $(".tab_content:first").show(); //Show first tab content

      //On Click Event
      $("ul.tabs li").click(function() {

        $("ul.tabs li").removeClass("active"); //Remove any "active" class
        $(this).addClass("active"); //Add "active" class to selected tab
        $(".tab_content").hide(); //Hide all tab content

        var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
        $(activeTab).fadeIn(); //Fade in the active ID content
        return false;
      });

    });
  </script>
  <script type="text/javascript">
    $(function(){
      $('.column').equalHeight();
    });
  </script>

</head>


<body>


<section id="secondary_bar">
  <div class="user">
    <p> Welcome to GoBig_RPG - Username (<a href="#">email</a>)</p>
    <!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
  </div>

</section><!-- end of secondary bar -->

<aside id="sidebar" class="column">

  <hr/>
  <h3></h3>
  <ul class="toggle">
    <div class="container">
      <button type="button"  class="myButton">    Health         </button>
    </div>
  </ul>
  <h3></h3>
  <ul class="toggle">
    <div class="container">
      <button type="button" class="myButton2">Intelligence   </button>
    </div>
  </ul>
  <h3></h3>
  <ul class="toggle">
    <div class="container">
      <button type="button" class="myButton3">Communication  </button>
    </div>
  </ul>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <ul class="toggle">
    <div class="container">
      <button type="button" class="myButton4">Summary  </button>
    </div>
  </ul>

</aside><!-- end of sidebar -->

<section id="main" class="column">

  <article class="module width_full">
    <header><h3>Stats</h3></header>
    <div class="module_content">
      <article class="stats_graph">
        <img src="http://chart.apis.google.com/chart?chxr=0,0,3000&chxt=y&chs=520x140&cht=lc&chco=76A4FB,80C65A&chd=s:Tdjpsvyvttmiihgmnrst,OTbdcfhhggcTUTTUadfk&chls=2|2&chma=40,20,20,30" width="520" height="140" alt="" />
      </article>

      <article class="stats_overview">
        <div class="overview_today">
          <p class="overview_day">Today</p>
          <p class="overview_count">6</p>
          <p class="overview_type">Scores</p>
        </div>
        <div class="overview_previous">
          <p class="overview_day">Average</p>
          <p class="overview_count">5</p>
          <p class="overview_type">Scores</p>
        </div>
      </article>
      <div class="clear"></div>
    </div>
  </article><!-- end of stats article -->

  <article class="module width_full">
    <header><h3 class="tabs_involved">Content Manager</h3>
    </header>

    <div class="tab_container">
      <div id="tab1" class="tab_content"-->
        <table class="tablesorter" cellspacing="0">
          <thead>
          <tr>
            <th></th>
            <th>Task Name</th>
            <th>Category</th>
            <th>Created On</th>
            <th>Is Task Accomplished ?</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td><input type="checkbox"></td>
            <td>Task 1</td>
            <td>Health</td>
            <td>2015_10_30</td>
            <td>
              <input type="submit" value="Yes" class="alt_btn">
              <input type="submit" value="No" class="alt_btn">
            </td>
          </tr>
          <tr>
            <td><input type="checkbox"></td>
            <td>Task 2</td>
            <td>Health</td>
            <td>2015_10_30</td>
            <td>
              <input type="submit" value="Yes" class="alt_btn">
              <input type="submit" value="No" class="alt_btn">
            </td>
          </tr>
          <tr>
            <td><input type="checkbox"></td>
            <td>Task 3</td>
            <td>Health</td>
            <td>2015_10_30</td>
            <td>
              <input type="submit" value="Yes" class="alt_btn">
              <input type="submit" value="No" class="alt_btn">
            </td>
          </tr>
          </tbody>
        </table>
      </div><!-- end of #tab1 -->
    </div><!-- end of #tab -->
  </article><!-- end of messages article -->


  <article class="module width_3_quarter">
    <header><h3>Create New Task</h3></header>
    <div class="module_content">
      <table class="tablesorter" cellspacing="0">
        <fieldset>
          <label>Task Name</label>
          <input type="text">
        </fieldset>
        <fieldset> <!-- to make two field float next to one another, adjust values accordingly -->
          <label>Category</label>
          <select style="width:92%;">
            <option>Health</option>
            <option>Intelligence</option>
            <option>Communication</option>
          </select>
        </fieldset>
        <fieldset>
          <label>Scores for Yes</label>
          <input type="text">
        </fieldset>
        <fieldset>
          <label>Scores for No</label>
          <input type="text">
        </fieldset>
      </table>
    </div>
    <footer>
      <div class="submit_link">
        <input type="submit" value="Create" class="alt_btn">
        <input type="submit" value="Reset">
      </div>
    </footer>
  </article><!-- end of post new article -->
</section>


</body>

</html>
