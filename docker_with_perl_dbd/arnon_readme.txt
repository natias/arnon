these are the step i did:

in host

$ docker run -it --rm --name my-running-app perl /bin/bash


in docker


$ apt update
$ apt-get install -y libaio1 alien
$ wget http://yum.oracle.com/repo/OracleLinux/OL7/oracle/instantclient/x86_64/getPackage/oracle-instantclient19.6-basic-19.6.0.0.0-1.x86_64.rpm
$ alien -i --scripts oracle-instantclient19.6-basic-19.6.0.0.0-1.x86_64.rpm
$ wget http://yum.oracle.com/repo/OracleLinux/OL7/oracle/instantclient/x86_64/getPackage/oracle-instantclient19.6-sdk-19.6.0.0.0-1.x86_64.rpm
$ alien -i --scripts oracle-instantclient19.6-sdk-19.6.0.0.0-1.x86_64.rpm
$ wget http://yum.oracle.com/repo/OracleLinux/OL7/oracle/instantclient/x86_64/getPackage/oracle-instantclient19.6-devel-19.6.0.0.0-1.x86_64.rpm
$ alien -i --scripts oracle-instantclient*.rpm
$ sqlplus 'c##mdx/MDX@172.17.0.1:1521/free'
$ cpan DBI
$ apt install vim
$ vim demo.pl
	use DBI;
	my $dbh = DBI->connect( "dbi:Oracle:host=172.17.0.1;service_name=free;port=1521", 'c##mdx', 'MDX' ) or die($DBI::errstr, "\n");
	my $sth = $dbh->prepare(
     		"SELECT 'Hi' h,'World' w 
         FROM dual"
      );
	my $rc = $sth->execute();

   		while (($h, $w) = $sth->fetchrow()) {
      		print "$h $w\n";
   	}

in host

$ docker commit my-running-app arnon_perl_db:1
$ docker save arnon_perl_db > arch.tar
$ split arch.tar


the results of split are in this folder



