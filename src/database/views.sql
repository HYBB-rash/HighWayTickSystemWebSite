
-- Train views
drop view IdAndTrainId;

create view IdAndTrainId as
    select id, TrainId
    from train;
go

select * from IdAndTrainId;

-- Station views
drop view IdAndNameInStation;
create view IdAndNameInStation as
    select id, name
    from station;
select * from IdAndNameInStation;

-- Pass views

create view IdStationIdAndTrainIdInPass as
    select id, TrainId, StationId
    from pass
select  * from IdStationIdAndTrainIdInPass;
