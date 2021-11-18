# MultiChiefStaff
<p><b>MultiChief</b> is an experimental microservice-based ERP system for construction industry (on-line and off-line interaction between departments and employees). <p/>
<p><b>MultiChiefStaff</b> is a microservice that is responsible for preparing data (DTO) for orchestrators (modules of <a href="https://github.com/LevGoryachev/MultiChiefMain">MultiChiefMain</a>).</p> 
<p><b>Summary: Java 11, Spring-Boot, Spring Security, Spring Data JPA (Hibernate)</b></p>
<p><b>Database: PostgreSQL</b></p>

<p>Database structure in files:</p>
<ul>
<li><b>MultiChiefStaff_DDL_v1.1.sql</b></li>
</ul>

<h3>Database physical diagram</h3>

![MultiChiefStaff_DDL_v1 1](https://user-images.githubusercontent.com/61917893/138785086-2dbfa5c0-40a6-46b0-880c-81d6fafc0106.jpg)


<p>Descriptions:</p>

<ul>
<li>employee - denormalized table because of dificulties with bringing to the standard between different countries</li>
<li>app_user_external_id - to connect with security service (if app_user_external_id not null - the employee has credentials to APP access)</li>
<li>labour_contract_external_id - to connect with document flow service (the employee should have a labour contract)</li>
<li>required_qty - quantity of required vacancies</li>
<li>manning_qty - quantity of occupied vacancies</li>
</ul>

<p>MultiChief (ERP). License: GNU GPL v3. Copyright (C) 2021 Lev Goryachev.</p>
